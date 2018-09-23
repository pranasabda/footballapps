package com.prana.footballapps.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.prana.footballapps.R
import com.prana.footballapps.database.FavoriteMatch
import com.prana.footballapps.model.MatchDataItem
import com.prana.footballapps.view.fragment.NextMatchFragment
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

class FavoriteMatchAdapter( private val favoriteMatch : List<FavoriteMatch>,
                            private val listener: (FavoriteMatch) -> Unit)
    : RecyclerView.Adapter<FavMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMatchViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.match_item_list, parent, false)
        return FavMatchViewHolder(view)
    }

    override fun getItemCount(): Int = favoriteMatch.size


    override fun onBindViewHolder(holder: FavMatchViewHolder, position: Int) {
        holder.bindItem(favoriteMatch[position], listener)
    }

}

class FavMatchViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val mDateEvent  : TextView = view.find(R.id.tv_date_event)
    val mHomeTeam   : TextView = view.find(R.id.tv_home_team)
    val mAwayTeam   : TextView = view.find(R.id.tv_away_team)
    val mHomeScore  : TextView = view.find(R.id.tv_home_score)
    val mAwayScore  : TextView = view.find(R.id.tv_away_score)

    /* TODO : Delete parameter -> listener: NextMatchFragment.OnFragmentInteractionListener?
     * Ganti dengan -> listener : (FavoriteMatch) -> Unit
     */
    fun bindItem(itemFav: FavoriteMatch, listener: (FavoriteMatch) -> Unit ) {
        mDateEvent.text = itemFav.dateEvent
        mHomeTeam.text = itemFav.homeTeam
        mAwayTeam.text = itemFav.awayTeam
        mHomeScore.text = itemFav.homeScore
        mAwayScore.text = itemFav.awayScore

        // Menggunakan simple fragment, dan listener : (FavoriteMatch) -> Unit
        itemView.onClick { listener(itemFav) }

     /*  // Tidak digunakan karean pakai simple fragment diatas
        itemView.setOnClickListener {
            listener?.onFragmentInteraction(item)
        }
    */

    }
}


