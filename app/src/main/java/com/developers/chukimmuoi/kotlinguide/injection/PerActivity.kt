package com.developers.chukimmuoi.kotlinguide.injection

import com.developers.chukimmuoi.kotlinguide.injection.component.ActivityComponent
import com.developers.chukimmuoi.kotlinguide.injection.module.ActivityModule
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 03/09/2017.
 *
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the Activity to be memorised in the
 * correct component.
 *
 * Phạm vi cho activity
 * Được sử dụng với class [ActivityComponent]: Dùng cho toàn class
 * và class [ActivityModule]: Dùng cho từng method trong class.
 *
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity