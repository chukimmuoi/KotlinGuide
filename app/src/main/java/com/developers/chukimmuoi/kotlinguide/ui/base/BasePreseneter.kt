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
class BasePreseneter<in T : MvpView> : Preseneter<T> {

    private var mMvpView: T? = null
        get() = mMvpView

    override fun attachView(mvpView: T) {
        mMvpView = mvpView
    }

    override fun detachView() {
        mMvpView = null
    }

    fun isViewAttached(): Boolean = mMvpView != null

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.attachView(MvpView) before requesting data to the Presenter")
}