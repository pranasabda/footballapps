package com.prana.footballapps.presenter

import com.google.gson.Gson
import com.prana.footballapps.ContextProviderTest
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.PlayerDataItem
import com.prana.footballapps.model.PlayerResponse
import com.prana.footballapps.view.PlayerView
import org.junit.Before
import org.junit.Test

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class PlayerPresenterTest {

    @Mock private lateinit var view: PlayerView
    @Mock private lateinit var apiRequest: ApiRequest
    @Mock private lateinit var gson: Gson

    private lateinit var presenter: PlayerPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PlayerPresenter(view, apiRequest, gson, ContextProviderTest())
    }

    @Test
    fun getPlayerListData() {

        val dataPlayer  : MutableList<PlayerDataItem> = mutableListOf()
        val response    = PlayerResponse(dataPlayer)
        val team = "133604"

        `when`(gson.fromJson(apiRequest.doRequest(
                TheSportDbApi.getPlayers(team) )
                , PlayerResponse::class.java
        )).thenReturn(response)

        presenter.getPlayerListData(team)
        verify(view).showPlayerListData(dataPlayer) // atau bisa ditulis : Mockito.verify(view).showPlayerListData(dataPlayer)
        Mockito.verify(view).showProgress()
        Mockito.verify(view).hideProgress()
    }
}