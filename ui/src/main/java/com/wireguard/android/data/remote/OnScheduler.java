/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.reactivex.rxjava3.core.Scheduler;
import retrofit2.Retrofit;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Observer subscribes and observes on the specified {@link Scheduler} in {@link Retrofit} services.
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface OnScheduler {
    SchedulerType observeOn() default SchedulerType.MAIN_THREAD;

    SchedulerType subscribeOn() default SchedulerType.IO;
}
