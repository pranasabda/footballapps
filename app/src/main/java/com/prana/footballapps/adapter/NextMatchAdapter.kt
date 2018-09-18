package com.prana.footballapps.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.prana.footballapps.R
import com.prana.footballapps.model.MatchDataItem
import com.prana.footballapps.view.fragment.NextMatchFragment
import org.jetbrains.anko.find

class NextMatchAdapter (
    private val dataItems: MutableList<MatchDataItem>,
    private val listener: NextMatchFragment.OnFragmentInteractionListener?)
    : RecyclerView.Adapter<NextMatchAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchAdapter.ViewHolder {
//      TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.match_item_list, parent, false )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return dataItems.size
    }

//    override fun getItemCount(): Int = dataItems.size

    override fun onBindViewHolder(holder: NextMatchAdapter.ViewHolder, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.bindItem(dataItems[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val mDateEvent  : TextView = view.find(R.id.tv_date_event)
        val mHomeTeam   : TextView = view.find(R.id.tv_home_team)
        val mAwayTeam   : TextView = view.find(R.id.tv_away_team)
        val mHomeScore  : TextView = view.find(R.id.tv_home_score)
        val mAwayScore  : TextView = view.find(R.id.tv_away_score)

        fun bindItem(item: MatchDataItem, listener: NextMatchFragment.OnFragmentInteractionListener?) {
            mDateEvent.text = item.mDateEvent
            mHomeTeam.text = item.mHomeTeam
            mAwayTeam.text = item.mAwayTeam
            mHomeScore.text = item.mHomeScore
            mAwayScore.text = item.mAwayScore

            itemView.setOnClickListener {
                listener?.onFragmentInteraction(item)
            }
        }
    }

}
