package com.developers.chukimmuoi.kotlinguide.injection.module

import android.app.Activity
import android.content.Context
import com.developers.chukimmuoi.kotlinguide.injection.ActivityContext
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
class ActivityModule(val mActivity: Activity) {

    @Provides
    fun provideActivity() : Activity = mActivity

    @Provides
    @ActivityContext
    fun provideContext(): Context = mActivity

}