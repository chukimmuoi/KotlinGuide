package com.developers.chukimmuoi.kotlinguide.injection.module

import android.app.Application
import android.content.Context
import com.developers.chukimmuoi.kotlinguide.data.remote.RibotsService
import com.developers.chukimmuoi.kotlinguide.injection.ApplicationContext
import dagger.Module
import dagger.Provides
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
@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    fun provideApplication(): Application = mApplication

    @Provides
    @ApplicationContext
    fun provideContext(): Context = mApplication

    @Provides
    @Singleton
    fun provideRibotsService() = RibotsService.Creator.newRibotsService()

}