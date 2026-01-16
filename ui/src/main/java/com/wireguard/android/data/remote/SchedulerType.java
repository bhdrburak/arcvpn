/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote;

/**
 * Scheduler types for RxJava.
 */
public enum SchedulerType {
    MAIN_THREAD,
    NEW_THREAD,
    IO,
    COMPUTATION
}
