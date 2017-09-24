package com.developers.chukimmuoi.kotlinguide.injection

import com.developers.chukimmuoi.kotlinguide.injection.component.ConfigPersistentComponent
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
 * A scoping annotation to permit dependencies conform to the life of the
 * [ConfigPersistentComponent]
 *
 * Phạm vi sử dụng cho presenter.
 * Được sử dụng cho [ConfigPersistentComponent]
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ConfigPersistent