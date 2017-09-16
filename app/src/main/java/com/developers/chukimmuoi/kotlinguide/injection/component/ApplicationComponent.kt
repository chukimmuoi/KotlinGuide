package com.developers.chukimmuoi.kotlinguide.injection.component

import android.app.Application
import android.content.Context
import com.developers.chukimmuoi.kotlinguide.data.SyncService
import com.developers.chukimmuoi.kotlinguide.injection.ApplicationContext
import com.developers.chukimmuoi.kotlinguide.injection.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 03/09/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(syncService: SyncService)

    @ApplicationContext fun context(): Context
    fun application(): Application

}