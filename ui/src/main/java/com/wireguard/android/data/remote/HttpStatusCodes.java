/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

/**
 * Created by sadikaltintoprak on 4/10/18.
 */

/**
 * Common http status codes.
 */
@IntDef({HttpStatusCodes.CONTINUE, HttpStatusCodes.OK, HttpStatusCodes.CREATED, HttpStatusCodes.NO_CONTENT, HttpStatusCodes.BAD_REQUEST, HttpStatusCodes.CONFLICT, HttpStatusCodes.UNPROCESSABLE_ENTITY,
        HttpStatusCodes.INTERNAL_SERVER_ERROR})
@Retention(RetentionPolicy.SOURCE)
public @interface HttpStatusCodes {
    int BAD_REQUEST = 400;
    int CONFLICT = 409;
    int CONTINUE = 100;
    int CREATED = 201;
    int INTERNAL_SERVER_ERROR = 500;
    int NO_CONTENT = 204;
    int OK = 200;
    int UNPROCESSABLE_ENTITY = 422;
}