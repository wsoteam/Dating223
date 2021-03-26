package com.dat.android.lips.utils

import android.content.Context
import android.content.SharedPreferences
import com.dat.android.lips.App

object PreferenceProvider {

    private const val KEY_URL = "KEY_URL"
    const val EMPTY_URL = "EMPTY_URL"
    const val MODERATOR_URL = "MODERATOR_URL"

    private const val KEY_ALARM = "KEY_ALARM"
    const val STATE_SET_ALARM = "STATE_SET_ALARM"
    const val STATE_NOT_SET_ALARM = "STATE_NOT_SET_ALARM"


    var sp: SharedPreferences =
        App.getInstance()
            .getSharedPreferences("", Context.MODE_PRIVATE)

    var editor = sp.edit()

    fun saveUrl(url: String) {
        editor.putString(
            KEY_URL, url
        )
        editor.commit()
    }

    fun getUrl(): String {
        val savedText = sp.getString(
            KEY_URL,
            EMPTY_URL
        )!!
        return savedText
    }

    fun setAlarmState(state: String) {
        editor.putString(
            KEY_ALARM, state
        )
        editor.commit()
    }

    fun getAlarmState(): String {
        val state = sp.getString(
            KEY_ALARM,
            STATE_NOT_SET_ALARM
        )!!
        return state
    }
}