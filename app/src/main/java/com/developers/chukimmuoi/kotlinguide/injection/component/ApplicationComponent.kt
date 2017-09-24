package com.developers.chukimmuoi.kotlinguide.injection.component

import android.app.Application
import android.content.Context
import com.developers.chukimmuoi.kotlinguide.data.DataManager
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
 *
 * [ApplicationComponent] là cha của [ConfigPersistentComponent] -> Dependent Components
 */
@Singleton // Scope
@Component(
        // https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2#dependent-components
        modules = arrayOf(ApplicationModule::class)
)
interface ApplicationComponent {

    // Vì là Dependent Components nên inject sẽ được thực hiện ở class cha.
    fun inject(syncService: SyncService)

    // Các phương thức được khai báo public ở đây để class con (ConfigPersistentComponent) có thể sử dụng.
    @ApplicationContext fun context(): Context
    fun application(): Application
    fun dataManager(): DataManager

}