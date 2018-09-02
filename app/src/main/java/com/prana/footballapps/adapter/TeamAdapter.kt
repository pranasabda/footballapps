package com.prana.footballapps.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.prana.footballapps.R
import com.prana.footballapps.model.TeamDataItem
import kotlinx.android.synthetic.main.team_item_list.view.* // Automatis terImport apabila menggunakan itemView

class TeamAdapter (private val context: Context, private val teamDataItem: List<TeamDataItem>, private val listener: (TeamDataItem) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.team_item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(teamDataItem[position], listener)
    }


    override fun getItemCount(): Int = teamDataItem.size // --> " = " artinya "{}", lihat dibawah untuk contohnya

    /* contoh :
    * override fun getItemCount(): Int {
    *       teamDataItem.size
    *  }
    * */

}

class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(teamDataItem: TeamDataItem, listener: (TeamDataItem) -> Unit) {
        itemView.name_team_view.text = teamDataItem.teamName
        Glide.with(itemView.context).load(teamDataItem.teamImage).into(itemView.image_team_view)

        itemView.setOnClickListener {
            listener(teamDataItem)
        }

    }

}