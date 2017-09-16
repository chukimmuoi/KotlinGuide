package com.developers.chukimmuoi.kotlinguide.util

import android.content.Context
import android.support.annotation.StringRes
import com.afollestad.materialdialogs.MaterialDialog
import com.developers.chukimmuoi.kotlinguide.R

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 16/09/2017.
 */
object DialogFactory {
    private var mMaterialDialog: MaterialDialog? = null

    fun dismissDialog() {
        mMaterialDialog?.dismiss()
        mMaterialDialog = null
    }

    fun showDialogBasic(context: Context, @StringRes title: Int, @StringRes content: Int,
                        @StringRes positive: Int, positiveAction: IDialogAction? = null,
                        @StringRes negative: Int? = null, negativeAction: IDialogAction? = null,
                        @StringRes neutral: Int? = null, neutralAction: IDialogAction? = null) {
        dismissDialog()

        var builder = MaterialDialog.Builder(context)
                .backgroundColorRes(R.color.colorDialogBackground)
                .title(title)
                .titleColorRes(R.color.colorDialogTitle)
                .content(content)
                .contentColorRes(R.color.colorDialogContent)
                .positiveText(positive)
                .positiveColorRes(R.color.colorDialogPositive)

        positiveAction?.let {
            builder.onPositive { _, _ -> positiveAction.Action() }
        }

        negative?.let {
            builder
                    .negativeText(negative)
                    .negativeColorRes(R.color.colorDialogNegative)
            negativeAction?.let {
                builder.onNegative { _, _ -> negativeAction.Action() }
            }
        }

        neutral?.let {
            builder
                    .neutralText(neutral)
                    .neutralColorRes(R.color.colorDialogNeutral)
            neutralAction?.let {
                builder.onNeutral { _, _ -> neutralAction.Action() }
            }
        }

        mMaterialDialog = builder.show()

    }

    interface IDialogAction {
        fun Action()
    }
}