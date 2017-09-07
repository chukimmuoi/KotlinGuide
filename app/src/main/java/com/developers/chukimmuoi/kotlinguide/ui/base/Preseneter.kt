package com.developers.chukimmuoi.kotlinguide.ui.base

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 02/09/2017.
 */
interface Preseneter<in V : MvpView> {
    fun attachView(mvpView: V)

    fun detachView()
}