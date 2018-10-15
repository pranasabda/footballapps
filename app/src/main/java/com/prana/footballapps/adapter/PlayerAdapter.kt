package com.prana.footballapps.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prana.footballapps.R
import com.prana.footballapps.model.PlayerDataItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.player_item_list.view.*

class PlayerAdapter ( private val playerDataItem: List<PlayerDataItem>,
                      private val listener: (PlayerDataItem) -> Unit)
                    : RecyclerView.Adapter<ViewHolderPlayer>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPlayer {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.player_item_list, parent, false)
        return ViewHolderPlayer(view)
    }

    override fun getItemCount(): Int = playerDataItem.size


    override fun onBindViewHolder(holder: ViewHolderPlayer, position: Int) {
        holder.bindItem(playerDataItem[position], listener)
    }

}

class ViewHolderPlayer(val view: View): RecyclerView.ViewHolder(view) {

    fun bindItem (playerDataItem: PlayerDataItem, listener: (PlayerDataItem) -> Unit) {
        itemView.tv_player_name.text = playerDataItem.mNamePlayer
        itemView.tv_player_position.text = playerDataItem.mPosition
        if(playerDataItem.mCutOut.isNullOrEmpty()) {
            itemView.img_player_potrait.setImageResource(R.drawable.icons8_contacts_filled_50)
        } else {
            Picasso.get().load(playerDataItem.mCutOut).into(itemView.img_player_potrait)
        }

        itemView.setOnClickListener {
            listener(playerDataItem)
        }

    }
}