package com.bulutangkis.apps.data

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

private const val KEY_GUIDE_MAIN = "key_guide_main"

class PreferenceProvider(
    context: Context
) {

    private val appContext = context.applicationContext

    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)



    fun setGuideStatus(status:Boolean) {
        preference.edit().putBoolean(
            KEY_GUIDE_MAIN,
            status
        ).apply()
    }

    fun getGuideStatus(): Boolean {
        return preference.getBoolean(KEY_GUIDE_MAIN, false)
    }

}