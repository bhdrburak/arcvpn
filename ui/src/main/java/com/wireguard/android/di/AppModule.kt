/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wireguard.android.common.error.UserDataValidator
import com.wireguard.android.common.network.NetworkChecker
import com.wireguard.android.data.common.ErrorHandler
import com.wireguard.android.data.remote.interceptor.AuthInterceptor
import com.wireguard.android.data.remote.VpnAPI
import com.wireguard.android.data.remote.interceptor.BaseUrlInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mvpntest.mobileitm.com/api/") // boş olamaz, ama override edilecek
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideBaseUrlInterceptor(): BaseUrlInterceptor {
        return BaseUrlInterceptor()
    }
    @Provides
    @Singleton
    fun provideAuthInterceptor(): AuthInterceptor = AuthInterceptor()
    @Provides
    @Singleton
    fun provideOkHttpClient(baseUrlInterceptor: BaseUrlInterceptor,
                            authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60.toLong(), TimeUnit.SECONDS)
            .connectTimeout(10.toLong(), TimeUnit.SECONDS)
            .addInterceptor(baseUrlInterceptor) // 👈 burada new değil, Hilt'ten geleni almamız gerekiyormuş.
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    fun provideUserDataValidator(): UserDataValidator {
        return UserDataValidator()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): VpnAPI {
        return retrofit.create(VpnAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideErrorHandler(
        networkChecker: NetworkChecker
    ): ErrorHandler {
        return ErrorHandler(networkChecker)
    }


}