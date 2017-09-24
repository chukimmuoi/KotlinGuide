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
 *
 * This component inject dependencies to all Activities across the application
 *
 * [ActivityComponent] là class con của [ConfigPersistentComponent]
 * hay [ConfigPersistentComponent] là class cha của [ActivityComponent]
 * @Subcomponent được sử dụng để chỉ ra sự phụ thuộc của [ActivityComponent] vào [ConfigPersistentComponent]
 * với cách khai báo này, [ActivityComponent] có thể truy cập sử dụng
 * mọi khai báo của module mà [ConfigPersistentComponent] có thể sử dụng.
 *
 * Lưu ý: Phạm vi (Scope) của [ActivityComponent] & [ConfigPersistentComponent] phải khác nhau.
 * Mô hình giữa [ActivityComponent] & [ConfigPersistentComponent] là SUBCOMPONENT.
 */

@PerActivity // Scope activity
@Subcomponent( // https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2#subcomponentsg
        modules = arrayOf(ActivityModule::class)
)
interface ActivityComponent {

    // Thực hiện inject ở class con thì class cha không cần inject nữa.
    fun inject(mainActivity: MainActivity)

}