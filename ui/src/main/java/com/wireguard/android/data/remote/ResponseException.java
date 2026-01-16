/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote;

import java.io.IOException;

import okhttp3.Response;

/**
 * Exception to throw when there is something wrong about the server response.
 */
public class ResponseException extends IOException {

    private final Response response;

    public ResponseException(Response response) {
        this.response = response;
    }

    /**
     * Http code that came from server.
     *
     * @return http code
     */
    public int getCode() {
        return response.code();
    }

    @Override
    public String getMessage() {
        return response.message();
    }

    public Response response() {
        return response;
    }
}
