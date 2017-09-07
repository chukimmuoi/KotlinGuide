package com.developers.chukimmuoi.kotlinguide.injection.component

import com.developers.chukimmuoi.kotlinguide.injection.PerActivity
import com.developers.chukimmuoi.kotlinguide.injection.module.ActivityModule
import com.developers.chukimmuoi.kotlinguide.ui.main.MainActivity
import dagger.Subcomponent

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 03/09/2017.
 */

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}