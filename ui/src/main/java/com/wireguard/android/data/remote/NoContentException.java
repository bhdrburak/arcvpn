/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote;

import okhttp3.Response;

/**
 * Created by sadikaltintoprak on 4/10/18.
 * <p>
 * Exception to throw when there is no content, eg: server returns empty response when it shouldn't.
 */
public class NoContentException extends ResponseException {

    private static final long serialVersionUID = 5170922915642095515L;

    public NoContentException(Response response) {
        super(response);
    }
}
