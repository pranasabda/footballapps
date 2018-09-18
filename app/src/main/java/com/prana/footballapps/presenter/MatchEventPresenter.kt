package com.prana.footballapps.presenter

import android.util.Log
import com.google.gson.Gson
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.MatchDataItemResponse
import com.prana.footballapps.view.MatchEventView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchEventPresenter (private val matchEventView: MatchEventView,
                           private val apiRequest: ApiRequest,
                           private val gson: Gson) {

    // Doc: Prana Sabda Prabawa 12-09-18, Mengambil data list Prev Match
    fun getMatchPrevData(league: String?){
        Log.d("debug","league :" + league)
        doAsync {
            val dataMatch = gson.fromJson(apiRequest
                    .doRequest(TheSportDbApi.getPrevMatch(league))
                    ,MatchDataItemResponse::class.java
            )
            Log.d("Debug", "data log: " + dataMatch)

            uiThread {
                matchEventView.showDataMatchList(dataMatch.events)
            }

        }
    }

    // Doc: Prana Sabda Prabawa 12-09-18, Mengambil data list Next Match
    fun getMatchNextData(league: String?) {
        doAsync {
            val dataMatch = gson.fromJson( apiRequest.doRequest(TheSportDbApi.getNextMatch(league))
                , MatchDataItemResponse::class.java )

            Log.d("Debug", "data log: " + dataMatch)
            uiThread { matchEventView.showDataMatchList(dataMatch.events) }
        }
    }

}

