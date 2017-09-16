package com.developers.chukimmuoi.kotlinguide.data.local

import android.content.Context
import android.content.SharedPreferences
import com.developers.chukimmuoi.kotlinguide.injection.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 10/09/2017.
 */
@Singleton
class PreferencesHelper @Inject constructor(@ApplicationContext context: Context) {

    private val mPref: SharedPreferences

    init {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun clear() = mPref.edit().clear().apply()

    companion object {

        val PREF_FILE_NAME = "android_boilerplate_pref_file"
    }

}