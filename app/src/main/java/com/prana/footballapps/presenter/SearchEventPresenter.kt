package com.prana.footballapps.presenter

import android.util.Log
import com.google.gson.Gson
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.EventDataResponse
import com.prana.footballapps.util.CoroutineContextProvider
import com.prana.footballapps.view.SearchEventView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class SearchEventPresenter(private val view:SearchEventView,
                           private val apiRequest: ApiRequest,
                           private val gson: Gson,
                           private val contextProvider: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getSearchEvent(teamName: String?) {
        view.showProgress()
        async(contextProvider.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportDbApi.getSearchMatches(teamName)),
                       EventDataResponse::class.java )
            }
            // Log.d("Debug","Message Data Search Event : "+view.showListEvent(data.await().event))
            view.showListEvent(data.await().event)
            view.hideProgress()
        }
    }
}