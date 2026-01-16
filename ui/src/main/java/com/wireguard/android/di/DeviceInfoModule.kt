/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.di

import com.wireguard.android.common.AndroidDeviceInfoProvider
import com.wireguard.android.domain.util.DeviceInfoProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DeviceInfoModule {

    @Binds
    @Singleton
    abstract fun bindDeviceInfoProvider(
        impl: AndroidDeviceInfoProvider
    ): DeviceInfoProvider
}