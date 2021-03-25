package com.dat.android.lips

import android.content.Context
import android.content.SharedPreferences

object PreferenceProvider {

    private const val KEY_URL = "KEY_URL"
    const val EMPTY_URL = "EMPTY_URL"
    const val MODERATOR_URL = "MODERATOR_URL"

    var sp: SharedPreferences =
        App.getInstance().getSharedPreferences("", Context.MODE_PRIVATE)

    var editor = sp.edit()

    fun saveUrl(url: String) {
        editor.putString(KEY_URL, url)
        editor.commit()
    }

    fun getUrl(): String {
        val savedText = sp.getString(KEY_URL, EMPTY_URL)!!
        return savedText
    }
}