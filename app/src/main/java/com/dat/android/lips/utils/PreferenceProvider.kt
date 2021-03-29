package com.dat.android.lips.utils

import android.app.Notification
import android.content.Context
import android.content.SharedPreferences
import com.dat.android.lips.App
import com.dat.android.lips.R

object PreferenceProvider {

    private const val KEY_URL = "KEY_URL"
    const val EMPTY_URL = "EMPTY_URL"
    const val MODERATOR_URL = "MODERATOR_URL"

    private const val KEY_ALARM = "KEY_ALARM"
    const val STATE_SET_ALARM = "STATE_SET_ALARM"
    const val STATE_NOT_SET_ALARM = "STATE_NOT_SET_ALARM"

    private const val KEY_TITLE = "KEY_TITLE"
    private const val KEY_LAST_URL = "KEY_LAST_URL"


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

    fun saveNotifCounter(counter: Int) {
        editor.putInt(KEY_TITLE, counter)
        editor.commit()
    }

    fun getNotifCounter(): Int {
        val notification = sp.getInt(KEY_TITLE, 0)!!
        return notification
    }

    fun setLastURL(url: String) {
        editor.putString(
            KEY_LAST_URL, url
        )
        editor.commit()
    }

    fun getLastURL(): String {
        val url = sp.getString(
            KEY_LAST_URL,
            ""
        )!!
        return url
    }
}