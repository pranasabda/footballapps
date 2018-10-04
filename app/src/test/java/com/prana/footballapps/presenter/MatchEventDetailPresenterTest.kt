package com.prana.footballapps.presenter

import com.google.gson.Gson
import com.prana.footballapps.ContextProviderTest
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.DetailMatchDataItem
import com.prana.footballapps.model.DetailMatchDataResponse
import com.prana.footballapps.view.DetailMatchEventView
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MatchEventDetailPresenterTest {

    @Mock private lateinit var view: DetailMatchEventView
    @Mock private lateinit var gson: Gson
    @Mock private lateinit var apiRequest: ApiRequest

    private lateinit var presenter: MatchEventDetailPresenter

    @Before
    fun setUp(){

        MockitoAnnotations.initMocks(this)
        presenter = MatchEventDetailPresenter(view, apiRequest, gson, ContextProviderTest() )
    }


    @Test
    fun testGetMatchEventDetail() {

        val dataDetail: MutableList<DetailMatchDataItem> = mutableListOf()
        val response = DetailMatchDataResponse(dataDetail)
        val event = "1234"

        `when`(gson.fromJson(apiRequest.doRequest(
                TheSportDbApi.getDetailMatch(event))
                , DetailMatchDataResponse::class.java
        )).thenReturn(response)

        presenter.getMatchEventDetail(event)

        verify(view).showDetailMatch(dataDetail)
    }

}