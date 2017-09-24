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
 *
 * Provide application-level dependencies.
 */
@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @Singleton // Xác định phạm vi phải trùng với component sử dụng module.
    fun provideApplication(): Application = mApplication

    @Provides
    @Singleton // Xác định phạm vi phải trùng với component sử dụng module.
    @ApplicationContext // Phân biệt khi trùng kiểu trả về.
    fun provideContext(): Context = mApplication

    @Provides
    @Singleton // Xác định phạm vi phải trùng với component sử dụng module
    fun provideRibotsService(): RibotsService = RibotsService.Creator.newRibotsService()

}