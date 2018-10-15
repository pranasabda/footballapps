package com.prana.footballapps.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.prana.footballapps.R
import com.prana.footballapps.model.MatchDataItem
import com.prana.footballapps.view.fragment.NextMatchFragment
import com.prana.footballapps.view.fragment.PrevMatchFragment
import org.jetbrains.anko.find
import java.text.SimpleDateFormat
import java.util.*

class PrevMatchAdapter (
        private val dataItems: MutableList<MatchDataItem>,
        private val listener: PrevMatchFragment.OnFragmentInteractionListener?)
        : RecyclerView.Adapter<PrevMatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.match_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return dataItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.bindItem(dataItems[position], listener)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)  {

        val mDateEvent  : TextView = view.find(R.id.tv_date_event)
        val mHomeTeam   : TextView = view.find(R.id.tv_home_team)
        val mAwayTeam   : TextView = view.find(R.id.tv_away_team)
        val mHomeScore  : TextView = view.find(R.id.tv_home_score)
        val mAwayScore  : TextView = view.find(R.id.tv_away_score)
        val mTime       : TextView = view.find(R.id.tv_time_event)

        fun bindItem(item: MatchDataItem, listener: PrevMatchFragment.OnFragmentInteractionListener?) {

            /*
            // Format Tanggal
//            val formatDate = SimpleDateFormat("yyyy-MM-dd")
//            val formatGMT = SimpleDateFormat("E, dd MMM yyyy")
//            val dateParse = formatDate.parse(item.mDateEvent)
//            val dateEvent = formatGMT.format(dateParse)
            */

            // val time = "19:00:00" // error apabila data time null / format tidak seragam
            val timeconvert = toGMTFormat(item.mDateEvent,item.mTime)
            val formatDate = SimpleDateFormat("E, dd MM yyyy")
            val formatTime = SimpleDateFormat("HH:mm")
            val date = formatDate.format(timeconvert)
            val timeNew = formatTime.format(timeconvert)

            mTime.text = item.mTime
            item.mDateEvent
            //mDateEvent.text = item.mDateEvent
            // mDateEvent.text = dateEvent
            mDateEvent.text = "$date"
            mTime.text      = "$timeNew"
            mHomeTeam.text  = item.mHomeTeam
            mAwayTeam.text  = item.mAwayTeam
            mHomeScore.text = item.mHomeScore
            mAwayScore.text = item.mAwayScore

            itemView.setOnClickListener {
                listener?.onFragmentInteraction(item)
            }
        }

    }

}

// Fungsi untuk convert Tanggal dan waktu ke GMT.
// Akan error apabila data time null / format tidak sesuai formatter
private fun toGMTFormat(date: String?, time: String?): Date? {
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    val dateTime = "$date $time"
    return formatter.parse(dateTime)
}