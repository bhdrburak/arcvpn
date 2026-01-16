/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import androidx.annotation.NonNull;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;

/**
 * Call adapter factory for Retrofit that handles threading with RxJava.
 * By default, all calls will be subscribed on Schedulers.io() and observed on
 * AndroidSchedulers.mainThread().
 */
public class RxOnSchedulerCallAdapterFactory extends CallAdapter.Factory {

    private final String TAG =
            this.getClass()
                    .getSimpleName();
    private final OnAsyncSetter<Response<?>> responseHandler;
    private final RxJava3CallAdapterFactory rxFactory = RxJava3CallAdapterFactory.create();
    private Scheduler observerScheduler;
    private Scheduler subscribeScheduler;

    public RxOnSchedulerCallAdapterFactory() {
        this(null);
    }

    public RxOnSchedulerCallAdapterFactory(OnAsyncSetter<Response<?>> responseHandler) {
        this(Schedulers.io(), AndroidSchedulers.mainThread(), responseHandler);
    }

    public RxOnSchedulerCallAdapterFactory(Scheduler subscribeScheduler, Scheduler observerScheduler) {
        this(subscribeScheduler, observerScheduler, null);
    }

    /**
     * Set default schedulers in building retrofit client.
     *
     * @param subscribeScheduler subscribeScheduler
     * @param observerScheduler  observerScheduler
     * @param responseHandler    responseHandler
     */
    public RxOnSchedulerCallAdapterFactory(Scheduler subscribeScheduler, Scheduler observerScheduler,
                                           OnAsyncSetter<Response<?>> responseHandler) {
        this.subscribeScheduler = subscribeScheduler;
        this.observerScheduler = observerScheduler;
        this.responseHandler = responseHandler;
    }

    @Override
    public CallAdapter<Object, ?> get(@NonNull Type returnType, @NonNull Annotation[] annotations, @NonNull Retrofit retrofit) {
        final CallAdapter<Object, Observable<?>> callAdapter =
                (CallAdapter) rxFactory.get(returnType, annotations, retrofit);
        return callAdapter != null
                ? new ThreadCallAdapter(annotations, callAdapter, retrofit)
                : null;
    }

    /**
     * Gets customized observable based on annotation defined in Service.
     *
     * @param observable  observable
     * @param annotations annotations
     * @return customized observable
     */
    protected Observable<?> getCustomizedObservable(@NonNull Call<?> call, Observable<?> observable, Annotation[] annotations) {

        for (Annotation annotation : annotations) {

            if (annotation instanceof OnScheduler) {

                final SchedulerType schedulerTypeSubscribeOn = ((OnScheduler) annotation).subscribeOn();
                if (schedulerTypeSubscribeOn.equals(SchedulerType.MAIN_THREAD)) {

                    subscribeScheduler = AndroidSchedulers.mainThread();

                } else if (schedulerTypeSubscribeOn.equals(SchedulerType.NEW_THREAD)) {

                    subscribeScheduler = Schedulers.newThread();

                } else if (schedulerTypeSubscribeOn.equals(SchedulerType.COMPUTATION)) {

                    subscribeScheduler = Schedulers.computation();
                }

                final SchedulerType schedulerTypeObserveOn = ((OnScheduler) annotation).observeOn();
                if (schedulerTypeObserveOn.equals(SchedulerType.NEW_THREAD)) {

                    observerScheduler = Schedulers.newThread();

                } else if (schedulerTypeObserveOn.equals(SchedulerType.IO)) {

                    observerScheduler = Schedulers.io();

                } else if (schedulerTypeObserveOn.equals(SchedulerType.COMPUTATION)) {

                    observerScheduler = Schedulers.computation();
                }
            }
        }

        return observable
                .subscribeOn(subscribeScheduler)
                .observeOn(observerScheduler);
    }

    private class FrameCall<T> implements Call<T> {

        private final Call<T> inputCall;

        private FrameCall(Call<T> inputCall) {
            this.inputCall = inputCall;
        }

        @Override
        public void cancel() {
            inputCall.cancel();
        }

        @NotNull
        @Override
        public Call<T> clone() {
            return new FrameCall<>(inputCall.clone());
        }

        @Override
        public void enqueue(@NotNull Callback<T> inputCallback) {

            final Callback<T> callback = new Callback<T>() {
                @Override
                public void onFailure(@NotNull Call<T> call, @NotNull Throwable t) {
                    inputCallback.onFailure(call, t);
                }

                @Override
                public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {

                    if (responseHandler != null) {
                        try {
                            responseHandler.onObjectResultWithException(response);
                        } catch (Exception e) {
                            Log.e(TAG, "enqueue onResponse: ", e);
                            inputCallback.onFailure(call, e);
                            return;
                        }
                    }

                    inputCallback.onResponse(call, response);
                }
            };

            inputCall.enqueue(callback);
        }

        @NotNull
        @Override
        public Response<T> execute() throws IOException {
            final Response<T> response = inputCall.execute();

            if (responseHandler != null) {
                responseHandler.onObjectResultWithException(response);
            }

            return response;
        }

        @Override
        public boolean isCanceled() {
            return inputCall.isCanceled();
        }

        @Override
        public boolean isExecuted() {
            return inputCall.isExecuted();
        }

        @NotNull
        @Override
        public Request request() {
            return inputCall.request();
        }

        @NotNull
        @Override
        public Timeout timeout() {
            return inputCall.timeout();
        }
    }

    private final class ThreadCallAdapter implements CallAdapter<Object, Observable<?>> {
        private final Annotation[] annotations;
        private final CallAdapter<Object, Observable<?>> delegateCallAdapter;
        private final Retrofit retrofit;

        ThreadCallAdapter(Annotation[] annotations, CallAdapter<Object, Observable<?>> delegateCallAdapter,
                          Retrofit retrofit) {
            this.annotations = annotations;
            this.delegateCallAdapter = delegateCallAdapter;
            this.retrofit = retrofit;
        }

        @NotNull
        @Override
        public Observable<?> adapt(@NonNull Call<Object> call) {
            return Observable.fromCallable(() -> new FrameCall<>(call))
                    .flatMap(stepCall ->
                            getCustomizedObservable(stepCall, delegateCallAdapter.adapt(stepCall), annotations));
                    /*.onErrorResumeNext(throwable -> {
                        return Observable.error(asRetrofitException(throwable));
                    });*/
        }

        @Override
        public Type responseType() {
            return delegateCallAdapter.responseType();
        }

    }
}