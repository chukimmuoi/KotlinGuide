package com.developers.chukimmuoi.kotlinguide.injection.module

import android.app.Activity
import android.content.Context
import com.developers.chukimmuoi.kotlinguide.injection.ActivityContext
import com.developers.chukimmuoi.kotlinguide.injection.PerActivity
import dagger.Module
import dagger.Provides

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
class ActivityModule(private val mActivity: Activity) {

    @Provides
    @PerActivity // Xác định phạm vi phải trùng với component sử dụng module.
    fun provideActivity() : Activity = mActivity

    @Provides
    @PerActivity // Xác định phạm vi phải trùng với component sử dụng module.
    @ActivityContext // Phân biệt khi trùng kiểu trả về.
    fun provideContext(): Context = mActivity

}