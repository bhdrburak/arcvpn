/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.common.error

sealed interface DataError :Error{
    enum class Network : DataError {

        /**
         * Sunucudan zamanında yanıt alınamadı (Genelde 408)
         */
        REQUEST_TIMEOUT,

        /**
         * Çok fazla istek gönderildi (Genelde 429)
         */
        TOO_MANY_REQUESTS,

        /**
         * İnternet bağlantısı yok veya bağlantı kesildi
         */
        NO_INTERNET,

        /**
         * Gönderilen veri boyutu çok büyük (Genelde 413)
         */
        PAYLOAD_TOO_LARGE,

        /**
         * Genel sunucu hatası (500–599 arası)
         */
        SERVER_ERROR,

        /**
         * Yanıt JSON verisi çözümlenemedi
         */
        SERIALIZATION,

        /**
         * 401 - Yetkilendirme hatası: Token geçersiz ya da oturum süresi dolmuş olabilir
         */
        UNAUTHORIZED,

        /**
         * 403 - Erişim reddedildi: Kullanıcının bu kaynağa erişim izni yok
         */
        FORBIDDEN,

        /**
         * 404 - Kaynak bulunamadı
         */
        NOT_FOUND,

        /**
         * 502 - Gateway hatası: Arka uç servislerinden alınan hata
         */
        BAD_GATEWAY,

        /**
         * Bilinmeyen veya sınıflandırılamayan bir hata oluştu
         */
        UNKNOWN
    }

    enum class Domain : DataError {
        NO_VALID_LOGIN_METHOD,
        EMPTY_CONFIG

    }

    enum class  Local : DataError{
        //Local
    }

}