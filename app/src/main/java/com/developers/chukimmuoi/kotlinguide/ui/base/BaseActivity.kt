package com.developers.chukimmuoi.kotlinguide.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.developers.chukimmuoi.kotlinguide.KotlinApplication
import com.developers.chukimmuoi.kotlinguide.injection.component.ActivityComponent
import com.developers.chukimmuoi.kotlinguide.injection.component.ConfigPersistentComponent
import com.developers.chukimmuoi.kotlinguide.injection.component.DaggerConfigPersistentComponent
import com.developers.chukimmuoi.kotlinguide.injection.module.ActivityModule
import timber.log.Timber
import java.util.concurrent.atomic.AtomicLong


/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 02/09/2017.
 */
class BaseActivity : AppCompatActivity() {

    private val TAG = BaseActivity::class.java.name

    private val KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID"
    private val NEXT_ID = AtomicLong(0)
    private val sComponentsMap: MutableMap<Long, ConfigPersistentComponent> = HashMap()

    private lateinit var mActivityComponent: ActivityComponent
    private var mActivityId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityId = savedInstanceState?.getLong(KEY_ACTIVITY_ID) ?: NEXT_ID.getAndIncrement()

        var configPersistentComponent: ConfigPersistentComponent
        if (!sComponentsMap.containsKey(mActivityId)) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", mActivityId);
            configPersistentComponent = DaggerConfigPersistentComponent.builder().applicationComponent(KotlinApplication.get(this).getComponent()).build()
            sComponentsMap.put(mActivityId, configPersistentComponent)
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", mActivityId);
            configPersistentComponent = sComponentsMap.getValue(mActivityId)
        }
        mActivityComponent = configPersistentComponent.activityComponet(ActivityModule(this))
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putLong(KEY_ACTIVITY_ID, mActivityId)
    }

    override fun onDestroy() {
        if (!isChangingConfigurations) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", mActivityId)
            sComponentsMap.remove(mActivityId)
        }
        super.onDestroy()
    }

    fun activityComponen(): ActivityComponent = mActivityComponent
}