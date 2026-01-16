/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.di

import com.wireguard.android.common.network.NetworkChecker
import com.wireguard.android.data.common.ErrorHandler
import com.wireguard.android.data.repository.AuthRepositoryImpl
import com.wireguard.android.domain.repository.AuthRepository
import com.wireguard.android.data.remote.VpnAPI
import com.wireguard.android.data.repository.ConfigRepositoryImpl
import com.wireguard.android.domain.repository.ConfigRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAuthRepository(
        apiService: VpnAPI,
        networkChecker: NetworkChecker,
        errorHandler: ErrorHandler
    ): AuthRepository = AuthRepositoryImpl(apiService,networkChecker,errorHandler)

    @Provides
    @Singleton
    fun provideConfigRepository(
        apiService: VpnAPI,
        networkChecker: NetworkChecker,
        errorHandler: ErrorHandler

    ): ConfigRepository = ConfigRepositoryImpl(apiService,networkChecker,errorHandler)
}
