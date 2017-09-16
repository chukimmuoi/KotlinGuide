package com.developers.chukimmuoi.kotlinguide.ui.main

import com.developers.chukimmuoi.kotlinguide.data.DataManager
import com.developers.chukimmuoi.kotlinguide.data.model.Ribot
import com.developers.chukimmuoi.kotlinguide.injection.ConfigPersistent
import com.developers.chukimmuoi.kotlinguide.ui.base.BasePresenter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 10/09/2017.
 */
@ConfigPersistent
class MainPresenter
@Inject constructor(private val mDataManager: DataManager) : BasePresenter<MainMvpView>() {

    override fun attachView(mvpView: MainMvpView) {
        super.attachView(mvpView)
    }

    override fun detachView() {
        super.detachView()
    }

    fun loadRibots() {
        checkViewAttached()
        mDataManager.getRibots()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<List<Ribot>> {
                    override fun onComplete() {

                    }

                    override fun onError(e: Throwable) {
                        Timber.e(e, "There was an error loading the ribots.")
                        //mMvpView?.showError()
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(ribots: List<Ribot>) {
                        if (ribots.isEmpty()) {
                            mMvpView?.showRibotsEmpty()
                        } else {
                            mMvpView?.showRibots(ribots)
                        }
                    }
        })
    }
}