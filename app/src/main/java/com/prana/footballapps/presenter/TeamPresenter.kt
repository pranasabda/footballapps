package com.prana.footballapps.presenter

import android.util.Log
import com.google.gson.Gson
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.TeamResponse
import com.prana.footballapps.util.CoroutineContextProvider
import com.prana.footballapps.view.TeamView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

//import org.jetbrains.anko.custom.async

class TeamPresenter(private val view:TeamView,
                    private val apiRequest: ApiRequest,
                    private val gson: Gson,
                    private val contextProvider: CoroutineContextProvider = CoroutineContextProvider()
                ) {


    // Menggunakan Coroutines
    fun getTeamListData(league: String?) {
        view.showloading()

        async(contextProvider.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportDbApi.getTeams(league)),
                        TeamResponse::class.java)
                }
            view.showTeamListData(data.await().teams)
            view.hideloading()
        }
    }

    // fungsi untuk pencarian data team berdasarkan nama team
    fun getSearchTeamData(teamName: String?) {
        view.showloading()

        async(contextProvider.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportDbApi.getSearchTeams(teamName)),
                        TeamResponse::class.java)
            }
            //Log.d("Debug","Data Team Search : " +view.showTeamListData(data.await().teams))

            view.showTeamListData(data.await().teams)
            view.hideloading()


        }
    }
}