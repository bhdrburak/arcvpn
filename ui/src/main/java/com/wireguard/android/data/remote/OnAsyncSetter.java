/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sadikaltintoprak on 6/26/18.
 */

/**
 * Interface for async set operations.
 *
 * @param <Type> type of inputs
 */
public interface OnAsyncSetter<Type> {

    /**
     * Passes given result as an input.
     *
     * @param input input
     */
    default void onBooleanResult(boolean input) {

    }

    /**
     * Passes given result as an input.
     *
     * @param input input
     */
    default void onIntegerResult(int input) {

    }

    /**
     * Passes given result array as an input.
     *
     * @param arrayInput input array
     */
    default void onListResult(ArrayList<Type> arrayInput) {

    }

    /**
     * Passes given object result as an input.
     *
     * @param input input object
     */
    default void onObjectResult(Type input) {

    }

    /**
     * Passes given object result as an input.
     *
     * @param input input object
     */
    default void onObjectResultWithException(Type input) throws IOException {

    }

    /**
     * Passes given result as an input.
     *
     * @param input input
     */
    default void onStringResult(String input) {
    }

    /**
     * Called when an operation is completed without any results.
     */
    default void onVoid() {

    }
}
