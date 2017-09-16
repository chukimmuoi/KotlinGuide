package com.developers.chukimmuoi.kotlinguide.data

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.IBinder
import com.developers.chukimmuoi.kotlinguide.KotlinApplication
import com.developers.chukimmuoi.kotlinguide.data.model.Ribot
import com.developers.chukimmuoi.kotlinguide.util.AndroidComponentUtil
import com.developers.chukimmuoi.kotlinguide.util.NetworkUtil
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class SyncService : Service() {

    @Inject lateinit var mDataManager: DataManager
    private lateinit var mSubcription: Unit

    companion object {

        fun getStartIntent(context: Context) = Intent(context, SyncService::class.java)
    }


    override fun onCreate() {
        super.onCreate()
        KotlinApplication.get(this).getComponent().inject(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timber.i("Starting sync...")

        if (!NetworkUtil.isNetworkConnected(this)) {
            Timber.i("Sync canceled, connection not available")
            AndroidComponentUtil.toggleComponent(this, SyncOnConnectionAvailable::class.java, true)
            stopSelf()
            return START_NOT_STICKY
        }

        mSubcription = mDataManager.syncRibots()
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<Ribot> {
                    override fun onNext(t: Ribot) {

                    }
                    override fun onComplete() {
                        Timber.i("Synced successfully!")
                        stopSelf(startId)
                    }

                    override fun onError(e: Throwable) {
                        Timber.w(e, "Error syncing.")
                        stopSelf(startId)
                    }

                    override fun onSubscribe(d: Disposable) {

                    }
                })

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    class SyncOnConnectionAvailable : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == ConnectivityManager.CONNECTIVITY_ACTION
                    && NetworkUtil.isNetworkConnected(context)) {
                Timber.i("Connection is now available, triggering sync...")
                AndroidComponentUtil.toggleComponent(context, SyncService::class.java, false)
                context.startService(getStartIntent(context))
            }
        }
    }
}
