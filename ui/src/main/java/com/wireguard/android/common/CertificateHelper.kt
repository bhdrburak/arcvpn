/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.common

import android.app.Activity
import android.content.Context
import android.security.KeyChain
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.security.KeyStore
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.Enumeration

object CertificateHelper {

    fun initKeyChain(activity: Activity) {
        KeyChain.choosePrivateKeyAlias(activity,
            { alias ->
                if (alias != null) {
                    getCertificate(alias, activity)
                } else {
                    Log.d("KeyChain", "Kullanıcı bir alias seçmedi")
                }
            }, null, null, null, -1, null
        )
    }

    private fun getCertificate(alias: String, context: Context) {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val privateKey = KeyChain.getPrivateKey(context, alias)
                val certChain = KeyChain.getCertificateChain(context, alias)

                if (privateKey != null && certChain != null) {
                    for (cert in certChain) {
                        Log.d("KeyChain", "Cert: ${cert.toString()}")
                    }
                }
            } catch (e: Exception) {
                Log.e("KeyChain", "Sertifika alınırken hata oluştu", e)
            }
        }
    }

    private fun getCa() {
        try {
            val ks = KeyStore.getInstance("AndroidCAStore")
            if (ks != null) {
                ks.load(null, null)
                val aliases: Enumeration<*> = ks.aliases()
                while (aliases.hasMoreElements()) {
                    val alias = aliases.nextElement() as String
                    val cert = ks.getCertificate(alias) as X509Certificate
                    Log.d("cacertlist", "onViewCreated: ${cert.issuerDN.name}")
                    if (cert.issuerDN.name.contains("MyCert")) {
                        var isCertExist = true
                        break
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: KeyStoreException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: CertificateException) {
            e.printStackTrace()
        }
    }
}