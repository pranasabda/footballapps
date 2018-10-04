package com.prana.footballapps.presenter

import com.google.gson.Gson
import com.prana.footballapps.ContextProviderTest
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.MatchDataItem
import com.prana.footballapps.model.MatchDataItemResponse
import com.prana.footballapps.view.MatchEventView
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MatchEventPresenterTest {

    @Mock private lateinit var view: MatchEventView
    @Mock private lateinit var gson: Gson
    @Mock private lateinit var apiRequest: ApiRequest

    private lateinit var presenter: MatchEventPresenter

    @Before
    fun setUp(){

        MockitoAnnotations.initMocks(this)
        presenter = MatchEventPresenter(view, apiRequest, gson, ContextProviderTest() )
    }

    @Test
    fun testGetMatchPrevData() {
        val dataMatch: MutableList<MatchDataItem> = mutableListOf()
        val response = MatchDataItemResponse(dataMatch)
        val league = "4335"

        `when`(gson.fromJson(apiRequest
                .doRequest(TheSportDbApi.getPrevMatch(league))
                , MatchDataItemResponse::class.java
        )).thenReturn(response)

        presenter.getMatchPrevData(league)

        verify(view).showDataMatchList(dataMatch)
    }

    /*
    @Test
    fun testGetMatchNextData() {
        val dataMatch: MutableList<MatchDataItem> = mutableListOf()
        val response = MatchDataItemResponse(dataMatch)
        val league = "4335"

        `when`(gson.fromJson(apiRequest
                .doRequest(TheSportDbApi.getNextMatch(league))
                , MatchDataItemResponse::class.java
        )).thenReturn(response)

        presenter.getMatchPrevData(league)

        verify(view).showDataMatchList(dataMatch)
    }
    */
}