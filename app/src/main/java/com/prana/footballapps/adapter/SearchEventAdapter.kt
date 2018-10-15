package com.prana.footballapps.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prana.footballapps.R
import com.prana.footballapps.model.EventDataItem
import kotlinx.android.synthetic.main.match_item_list.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.text.SimpleDateFormat
import java.util.*

class SearchEventAdapter(private var eventDataItem: List<EventDataItem>
                         , private val listener: (EventDataItem) -> Unit)
    :RecyclerView.Adapter<ViewHolderSearch>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSearch {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.match_item_list, parent, false)
        return ViewHolderSearch(view)
    }

    override fun getItemCount(): Int = eventDataItem.size

    override fun onBindViewHolder(holder: ViewHolderSearch, position: Int) {
        holder.bindItem(eventDataItem[position], listener)
    }

}

class ViewHolderSearch(val view: View): RecyclerView.ViewHolder(view) {

    fun bindItem(eventData: EventDataItem, listener: (EventDataItem) -> Unit){

        // Format Tanggal
        val formatDate = SimpleDateFormat("yyyy-MM-dd")
        val formatGMT = SimpleDateFormat("E, dd MMM yyyy")
        val dateParse = formatDate.parse(eventData.mDateEvent)
        val dateEvent = formatGMT.format(dateParse)

        // Data Time pada endpoint --> searchevents.php format tidak seragam.
//        val timeconvert = toGMTFormat(eventData.mDateEvent,eventData.mTime)
//        val formatDate = SimpleDateFormat("E, dd MM yyyy")
//        val formatTime = SimpleDateFormat("HH:mm")
//        val dateEvent = formatDate.format(timeconvert)
//        val timeNew = formatTime.format(timeconvert)

        //itemView.tv_date_event.text = eventData.mDateEvent
        itemView.tv_date_event.text = dateEvent
        itemView.tv_time_event.text = eventData.mTime
        itemView.tv_home_team.text = eventData.mHomeTeam
        itemView.tv_away_team.text = eventData.mAwayTeam
        itemView.tv_home_score.text = eventData.mHomeScore
        itemView.tv_away_score.text = eventData.mAwayScore


        //itemView.onClick{ listener(eventData)}

        itemView.setOnClickListener {
            listener(eventData)
        }
    }
}

// TODO : Di close karena data TIME pada endpoint searchevents.php tidak seragam formatnya
// Fungsi untuk convert Tanggal dan waktu ke GMT.
//private fun toGMTFormat(date: String?, time: String?): Date? {
//    if(time.isNullOrEmpty()) { var time = "00:00:00" }
//    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//    formatter.timeZone = TimeZone.getTimeZone("UTC")
//    val dateTime = "$date $time"
//    return formatter.parse(dateTime)
//}