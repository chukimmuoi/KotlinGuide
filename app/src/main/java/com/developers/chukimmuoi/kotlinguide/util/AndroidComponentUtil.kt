package com.developers.chukimmuoi.kotlinguide.util

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 14/09/2017.
 */
object AndroidComponentUtil {

    fun toggleComponent(context: Context, componentClass: Class<*>, enable: Boolean) {
        val componetName = ComponentName(context, componentClass)
        val pm = context.packageManager
        pm.setComponentEnabledSetting(componetName,
                if (enable)
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                else
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP)
    }

    fun isServiceRunning(context: Context, serviceClass: Class<Any>): Boolean {
        var manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        return manager.getRunningServices(Int.MAX_VALUE).any { serviceClass.name == it.service.className }
    }
}