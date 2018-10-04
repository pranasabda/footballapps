package com.prana.footballapps.presenter

import android.util.Log
import com.google.gson.Gson
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.MatchDataItemResponse
import com.prana.footballapps.util.CoroutineContextProvider
import com.prana.footballapps.view.MatchEventView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class MatchEventPresenter (private val matchEventView: MatchEventView,
                           private val apiRequest: ApiRequest,
                           private val gson: Gson
                           ,private val context: CoroutineContextProvider = CoroutineContextProvider() // ketika menggunakan Coroutine dan perlu Unit Test -- > Constructor ini akan dimanfaatkan untuk pengganti UI pada async(UI)
                        ) {

    /* Tidak menggunakan Coroutines
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
    */

    /* Menggunakan Coroutines */
    // Doc: Prana Sabda Prabawa 12-09-18, Mengambil data list Prev Match
    fun getMatchPrevData(league: String?){
        // Log.d("debug","league :" + league)
        async(context.main) {
            val dataMatch = bg { // --> bg untuk menjalankan di background coroutines
                gson.fromJson(apiRequest
                        .doRequest(TheSportDbApi.getPrevMatch(league))
                        , MatchDataItemResponse::class.java
                )
            }
             // Log.d("Debug", "data log: " + dataMatch)

            matchEventView.showDataMatchList(dataMatch.await().events)
        }
    }

    /* Tidak menggunakan Coroutines
    // Doc: Prana Sabda Prabawa 12-09-18, Mengambil data list Next Match
    fun getMatchNextData(league: String?) {
        doAsync {
            val dataMatch = gson.fromJson( apiRequest.doRequest(TheSportDbApi.getNextMatch(league))
                , MatchDataItemResponse::class.java )

            Log.d("Debug", "data log: " + dataMatch)
            uiThread { matchEventView.showDataMatchList(dataMatch.events) }
        }
    }
    */

    fun getMatchNextData(league: String?) {
        async(context.main) {
            val dataMatch = bg {
                gson.fromJson( apiRequest.doRequest(TheSportDbApi.getNextMatch(league))
                    , MatchDataItemResponse::class.java )
            }
            //Log.d("Debug", "data log: " + dataMatch)
            matchEventView.showDataMatchList(dataMatch.await().events)
        }
    }
}
