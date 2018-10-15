package com.prana.footballapps.presenter

import com.google.gson.Gson
import com.prana.footballapps.ContextProviderTest
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.TeamDataItem
import com.prana.footballapps.model.TeamResponse
import com.prana.footballapps.view.TeamView
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TeamPresenterTest {

    @Mock private lateinit var view: TeamView
    @Mock private lateinit var gson: Gson
    @Mock private lateinit var apiRequest: ApiRequest

    private lateinit var presenter: TeamPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamPresenter(view,apiRequest,gson,ContextProviderTest())
    }

    @Test
    fun getTeamListData() {

        val dataTeam: MutableList<TeamDataItem> = mutableListOf()
        val response = TeamResponse(dataTeam)
        val league = "Spanish La Liga"

        `when`(gson.fromJson(apiRequest.doRequest(TheSportDbApi.getTeams(league)),
                TeamResponse::class.java
        )).thenReturn(response)

        presenter.getTeamListData(league)
        verify(view).showTeamListData(dataTeam)
        verify(view).showloading()
        verify(view).hideloading()

    }

    // Pilih Salah satu Test
    /*
    //@Test
    fun getSearchTeamData() {
        val dataTeam: MutableList<TeamDataItem> = mutableListOf()
        val response = TeamResponse(dataTeam)
        val team = "Juventus"

        `when`(gson.fromJson(apiRequest.doRequest(TheSportDbApi.getSearchTeams(team)),
                TeamResponse::class.java
        )).thenReturn(response)

        presenter.getSearchTeamData(team)
        verify(view).showTeamListData(dataTeam)
        verify(view).showloading()
        verify(view).hideloading()
    }
    */
}