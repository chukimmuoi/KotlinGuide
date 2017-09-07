package com.developers.chukimmuoi.kotlinguide.injection.component

import com.developers.chukimmuoi.kotlinguide.injection.ConfigPersistent
import com.developers.chukimmuoi.kotlinguide.injection.module.ActivityModule
import dagger.Component

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 03/09/2017.
 */
@ConfigPersistent
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface ConfigPersistentComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

}