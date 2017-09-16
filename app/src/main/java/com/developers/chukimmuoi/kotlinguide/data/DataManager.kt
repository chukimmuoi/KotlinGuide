package com.developers.chukimmuoi.kotlinguide.data

import com.developers.chukimmuoi.kotlinguide.data.local.DatabaseHelper
import com.developers.chukimmuoi.kotlinguide.data.local.PreferencesHelper
import com.developers.chukimmuoi.kotlinguide.data.model.Ribot
import com.developers.chukimmuoi.kotlinguide.data.remote.RibotsService
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 10/09/2017.
 */
@Singleton
class DataManager
@Inject constructor(private val mRebotsService: RibotsService,
                    private val mPreferencesHelper: PreferencesHelper,
                    private val mDatabaseHelper: DatabaseHelper) {

    fun getPreferencesHelper(): PreferencesHelper {
        return mPreferencesHelper
    }

    fun syncRibots(): Observable<Ribot> {
        return mRebotsService.getRibots().concatMap { t -> mDatabaseHelper.setRibots(t) }
    }

    fun getRibots(): Observable<List<Ribot>> = mDatabaseHelper.ribots.distinct()
}