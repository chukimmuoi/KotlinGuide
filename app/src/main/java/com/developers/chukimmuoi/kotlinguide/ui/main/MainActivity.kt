package com.developers.chukimmuoi.kotlinguide.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.developers.chukimmuoi.kotlinguide.R
import com.developers.chukimmuoi.kotlinguide.data.SyncService
import com.developers.chukimmuoi.kotlinguide.data.model.Ribot
import com.developers.chukimmuoi.kotlinguide.ui.base.BaseActivity
import com.developers.chukimmuoi.kotlinguide.util.DialogFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMvpView {

    @Inject lateinit var mMainPresenter: MainPresenter
    @Inject lateinit var mRibotsAdapter: RibotsAdapter

    /**
     * Return an Intent to start this Activity.
     * triggerDataSyncOnCreate allows disabling the background sync service onCreate. Should
     * only be set to false during testing.
     */
    companion object {
        private val EXTRA_TRIGGER_SYNC_FLAG =
                "com.developers.chukimmuoi.kotlinguide.ui.main.MainActivity.EXTRA_TRIGGER_SYNC_FLAG"

        fun getStartIntent(context: Context, triggerDataSyncOnCreate: Boolean) : Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(EXTRA_TRIGGER_SYNC_FLAG, triggerDataSyncOnCreate)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)
        setContentView(R.layout.activity_main)

        mRecyclerView.adapter = mRibotsAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mMainPresenter.attachView(this)
        mMainPresenter.loadRibots()

        if(intent.getBooleanExtra(EXTRA_TRIGGER_SYNC_FLAG, true)) {
            startService(SyncService.getStartIntent(this))
        }
    }

    override fun onDestroy() {
        mMainPresenter.detachView()

        super.onDestroy()
    }

    /***** MVP View methods implementation *****/

    override fun showRibots(ribots: List<Ribot>) {
        mRibotsAdapter.setRibots(ribots)
        mRibotsAdapter.notifyDataSetChanged()
    }

    override fun showRibotsEmpty() {
        mRibotsAdapter.setRibots(Collections.emptyList())
        mRibotsAdapter.notifyDataSetChanged()

        Toast.makeText(this, R.string.empty_ribots, Toast.LENGTH_LONG).show();
    }

    override fun showError() {
        DialogFactory.createGenericErrorDialog(this,
                getString(R.string.error_loading_ribots))
                .show()
    }

}
