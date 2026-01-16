/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote;

import java.util.List;

/**
 * Created by sadikaltintoprak on 6/26/18.
 */

/**
 * Interface for async get operations.
 *
 * @param <T> type to return
 * @param <V> type of input
 */
public interface OnAsyncGetter<T, V> {

    /**
     * @param input input that was used for the operation
     * @return result item
     */
    default T onGet(V input) {
        return null;
    }

    /**
     * @return result item
     */
    default T onGet() {
        return null;
    }

    /**
     * @param input input that was used for the operation
     * @return result item list
     */
    default List<T> onGetList(V input) {
        return null;
    }

    /**
     * @return result item list
     */
    default List<T> onGetList() {
        return null;
    }
}
