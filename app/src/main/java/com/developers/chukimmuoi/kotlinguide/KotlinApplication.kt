package com.developers.chukimmuoi.kotlinguide

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.developers.chukimmuoi.kotlinguide.injection.component.ApplicationComponent
import com.developers.chukimmuoi.kotlinguide.injection.component.DaggerApplicationComponent
import com.developers.chukimmuoi.kotlinguide.injection.module.ApplicationModule
import io.fabric.sdk.android.Fabric
import timber.log.Timber

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 03/09/2017.
 */
class KotlinApplication : Application() {

    private lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Fabric.with(this, Crashlytics())
        }
    }

    companion object {

        fun get(context: Context): KotlinApplication {
            return context.applicationContext as KotlinApplication
        }
    }


    fun getComponent(): ApplicationComponent {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        }
        return mApplicationComponent
    }

    fun setComponent(applicationComponent: ApplicationComponent) {
        mApplicationComponent = applicationComponent
    }
}