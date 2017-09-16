package com.developers.chukimmuoi.kotlinguide.ui.main

import com.developers.chukimmuoi.kotlinguide.data.model.Ribot
import com.developers.chukimmuoi.kotlinguide.ui.base.MvpView



/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 09/09/2017.
 */
interface MainMvpView : MvpView {

    fun showRibots(ribots: List<Ribot>)

    fun showRibotsEmpty()

    fun showError()

}