/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.common.uihelpers

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.View
import com.google.android.material.snackbar.Snackbar

object Helpers {

    fun showCustomSnackbar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(Color.BLACK)
            .setTextColor(Color.BLACK)
            .setBackgroundTintMode(PorterDuff.Mode.XOR)
            .show()
    }

    fun showCustomSnackbarWithAction(
        view: View,
        message: String,
        actionText: String? = null,
        actionCallback: (() -> Unit)? = null
    ) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            .setBackgroundTint(Color.BLACK)
            .setTextColor(Color.BLACK)
            .setBackgroundTintMode(PorterDuff.Mode.XOR)

        if (!actionText.isNullOrEmpty() && actionCallback != null) {
            snackbar.setAction(actionText) {
                actionCallback()
            }
            snackbar.setActionTextColor(Color.BLACK)
        }
        snackbar.show()
    }


}