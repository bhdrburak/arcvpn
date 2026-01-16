package com.wireguard.android.common.local

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


open class CacheManager(val context: Context) {

    private val gson: Gson = Gson()
    private val prefs: SharedPreferences = context.getSharedPreferences("com.mobileitm.vpn", Context.MODE_PRIVATE)

    fun readString(key: String, defaultValue: String): String {
        return prefs.getString(key, defaultValue) ?: defaultValue
    }

    fun readBoolean(key: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    fun <T> read(key: String, defaultValue: T): T {
        return when (defaultValue) {
            is String -> prefs.getString(key, defaultValue as String) as T ?: defaultValue
            is Int -> prefs.getInt(key, defaultValue as Int) as T ?: defaultValue
            is Boolean -> prefs.getBoolean(key, defaultValue as Boolean) as T ?: defaultValue
            is Long -> prefs.getLong(key, defaultValue as Long) as T ?: defaultValue
            else -> defaultValue
        }
    }

    fun writeString(key: String, value: String) {
        Log.d("LogControl", "Key: $key - Value: $value")
        prefs.edit { putString(key, value).commit() }
    }

    fun writeBoolean(key: String, value: Boolean) {
        prefs.edit { putBoolean(key, value).commit() }
    }

    fun <T> write(key: String, value: T) {
        when (value) {
            is String -> prefs.edit { putString(key, value).commit() }
            is Int -> prefs.edit { putInt(key, value).commit() }
            is Boolean -> prefs.edit { putBoolean(key, value).commit() }
            is Long -> prefs.edit { putLong(key, value).commit() }
            else -> Unit
        }
    }

    fun <T> readObject(key: String? = null, target: Class<T>): T? {
        try {
            key?.let { safeKey ->
                return gson.fromJson(read(safeKey, ""), target)
            } ?: return gson.fromJson(read(target.simpleName, ""), target) as T
        } catch (e: Exception) {
            return null
        }
    }

    fun writeObject(key: String? = null, data: Any) {
        key?.let { safeKey ->
            write(safeKey, gson.toJson(data))
        } ?: write(data::class.java.simpleName, gson.toJson(data))
    }

    fun clearObject(key: String): Unit = prefs.edit {
        remove(key)
    }

    fun clearEverything(successFunction: () -> Unit = {}) {
        prefs.edit {
            clear().commit()
            GlobalScope.launch(Dispatchers.Main) { successFunction() }
        }
    }
}