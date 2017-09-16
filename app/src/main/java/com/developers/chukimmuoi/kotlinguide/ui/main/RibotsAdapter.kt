package com.developers.chukimmuoi.kotlinguide.ui.main

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.developers.chukimmuoi.kotlinguide.R
import com.developers.chukimmuoi.kotlinguide.data.model.Ribot
import kotlinx.android.synthetic.main.item_ribot.view.*
import javax.inject.Inject



/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : KotlinGuide
 * Created by chukimmuoi on 15/09/2017.
 */
class RibotsAdapter
@Inject constructor() : RecyclerView.Adapter<RibotsAdapter.RibotViewHolder>() {

    private var mRibots: List<Ribot> = ArrayList()

    fun setRibots(ribots: List<Ribot>) {
        mRibots = ribots
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RibotViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ribot, parent, false)
        return RibotViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RibotViewHolder, position: Int) {
        val ribot = mRibots[position]
        holder.hexColorView.setBackgroundColor(Color.parseColor(ribot.profile.hexColor))
        holder.nameTextView.text = String.format("%s %s",
                ribot.profile.name.first,
                ribot.profile.name.last)
        holder.emailTextView.text = ribot.profile.email
    }

    override fun getItemCount(): Int {
        return mRibots.size
    }

    inner class RibotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hexColorView: View = itemView.view_hex_color
        val nameTextView: TextView = itemView.text_name
        val emailTextView: TextView = itemView.text_email
    }
}