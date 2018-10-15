package com.prana.footballapps.presenter

import android.util.Log
import com.google.gson.Gson
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.PlayerResponse
import com.prana.footballapps.util.CoroutineContextProvider
import com.prana.footballapps.view.PlayerView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class PlayerPresenter(private val view: PlayerView,
                      private val apiRequest: ApiRequest,
                      private val gson: Gson,
                      private val contextProvider: CoroutineContextProvider = CoroutineContextProvider()
){

    // Menggunakan Coroutines
    fun getPlayerListData(id: String?) {
        view.showProgress()

        async(contextProvider.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportDbApi.getPlayers(id)),
                        PlayerResponse::class.java)
            }
            // Log.d("debug","Data Player API"+ data.await().player)
            view.showPlayerListData(data.await().player)
            view.hideProgress()

        }
    }
}