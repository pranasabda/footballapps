package com.prana.footballapps.presenter

import com.google.gson.Gson
import com.prana.footballapps.ContextProviderTest
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.EventDataItem
import com.prana.footballapps.model.EventDataResponse
import com.prana.footballapps.view.SearchEventView
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class SearchEventPresenterTest {

    @Mock private lateinit var view: SearchEventView
    @Mock private lateinit var gson: Gson
    @Mock private lateinit var apiRequest: ApiRequest

    private lateinit var presenter: SearchEventPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = SearchEventPresenter(view,apiRequest,gson, ContextProviderTest())
    }

    @Test
    fun getSearchEvent() {

        val dataSearchEvent : MutableList<EventDataItem> = mutableListOf()
        val response    = EventDataResponse(dataSearchEvent)
        val event       = "Real Madrid"

        `when`(gson.fromJson(apiRequest
                .doRequest(TheSportDbApi.getSearchMatches(event))
                ,EventDataResponse::class.java
        )).thenReturn(response)

        presenter.getSearchEvent(event)

        verify(view).showListEvent(dataSearchEvent)
        verify(view).showProgress()
        verify(view).hideProgress()
    }
}