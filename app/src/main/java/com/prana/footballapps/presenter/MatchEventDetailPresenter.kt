package com.prana.footballapps.presenter

import com.google.gson.Gson
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.api.TheSportDbApi
import com.prana.footballapps.model.BadgeResponse
import com.prana.footballapps.model.DetailMatchDataResponse
import com.prana.footballapps.view.DetailMatchEventView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchEventDetailPresenter ( public val detailMatchEventView: DetailMatchEventView,
                                  public val apiRequest: ApiRequest,
                                  public val gson: Gson ) {

    fun getTeamBadge( team: String?, teamType: String? ){

        doAsync {
            val dataTeam = gson.fromJson(apiRequest
                    .doRequest(TheSportDbApi.getBadge(team))
                    , BadgeResponse::class.java )

            uiThread {
                if(teamType == "Away")
                    detailMatchEventView.showAwayTeamBadge(dataTeam.teams)
                else
                    detailMatchEventView.showHomeTeamBadge(dataTeam.teams)

            }
        }
    }

    fun getMatchEventDetail(event: String?){

        doAsync {
            val dataDetail = gson.fromJson( apiRequest.doRequest(
                    TheSportDbApi.getDetailMatch(event))
                    , DetailMatchDataResponse::class.java )

            uiThread {
                detailMatchEventView.showDetailMatch(dataDetail.events)
            }
        }
    }

}