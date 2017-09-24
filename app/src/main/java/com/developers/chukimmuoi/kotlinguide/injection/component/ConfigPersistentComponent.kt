package com.developers.chukimmuoi.kotlinguide.injection.component

import com.developers.chukimmuoi.kotlinguide.injection.ConfigPersistent
import com.developers.chukimmuoi.kotlinguide.injection.module.ActivityModule
import com.developers.chukimmuoi.kotlinguide.ui.base.BaseActivity
import dagger.Component

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 03/09/2017.
 *
 * A dagger component that will live during the lifecycle of an Activity but it won't
 * be destroy during configuration changes. Check [BaseActivity] to see how this components
 * survives configuration changes.
 * Use the [ConfigPersistent] scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 *
 * [ConfigPersistentComponent] là cha của [ActivityComponent] -> SUBCOMPONENT
 * nhưng lại phụ thuộc (là con) của [ApplicationComponent] -> Dependent Components
 */
@ConfigPersistent // Scope presenter
@Component(
        // https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2#dependent-components
        dependencies = arrayOf(ApplicationComponent::class)
)
interface ConfigPersistentComponent {

    // Thể hiện: ConfigPersistentComponent là cha của ActivityComponent
    fun activityComponent(activityModule: ActivityModule): ActivityComponent

}