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
open class BasePresenter<T : MvpView> : Preseneter<T> {

    var mMvpView: T? = null
        private set

    override fun attachView(mvpView: T) {
        mMvpView = mvpView
    }

    override fun detachView() {
        mMvpView = null
    }

    private val isViewAttached: Boolean
        get() = mMvpView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.attachView(MvpView) before requesting data to the Presenter")
}