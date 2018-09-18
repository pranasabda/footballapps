package com.prana.footballapps.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.google.gson.Gson
import com.prana.footballapps.R
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.model.BadgeDataItem
import com.prana.footballapps.model.DetailMatchDataItem
import com.prana.footballapps.presenter.MatchEventDetailPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match_event.*

class DetailMatchEventActivity : AppCompatActivity(), DetailMatchEventView {

    private lateinit var detailPresenter: MatchEventDetailPresenter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match_event)

        val id_event    = intent.getStringExtra("id_event")
        val home_team   = intent.getStringExtra("home_team")
        val home_score  = intent.getStringExtra("home_score")
        val away_team   = intent.getStringExtra("away_team" )
        val away_score  = intent.getStringExtra( "away_score")
        val date_event  = intent.getStringExtra("date_event")

        progressBar = progress_bar_details
        tv_date_event_details.text  = date_event
        tv_home_team_details.text   = home_team
        tv_home_score_details.text  = home_score
        tv_away_team_details.text   = away_team
        tv_away_score_details.text  = away_score

        showProgress(progressBar)

        val apiReq = ApiRequest()
        val gson = Gson()
        detailPresenter = MatchEventDetailPresenter(this, apiReq, gson)

        detailPresenter.getMatchEventDetail(id_event)
        detailPresenter.getTeamBadge(home_team, "Home")
        detailPresenter.getTeamBadge(away_team, "Away")

    }

    override fun showProgress(progressBar: ProgressBar) {
        progressBar.visibility= View.VISIBLE
    }

    override fun hideProgress(progressBar: ProgressBar) {
        progressBar.visibility= View.GONE
    }

    override fun showDetailMatch(data: List<DetailMatchDataItem>) {

        // =========== HOME TEAM DATA ============ //
        val home_Formation      = getDataList(data[0].mHomeFormation.toString().trim())
        val home_GoalDetails    = getDataList(data[0].mHomeGoalDetails)
        val home_Shot           = getDataList(data[0].mHomeShots)
        val home_GoalKeeper     = getDataList(data[0].mHomeLineupGoalkeeper)
        val home_Defense        = getDataList(data[0].mHomeLineupDefense)
        val home_Midfield       = getDataList(data[0].mHomeLineupMid)
        val home_Forward        = getDataList(data[0].mHomeLineupForward)
        val home_Substitutes    = getDataList(data[0].mHomeLineupSubstitutes)
        //        val home_Formation      = data[0].mHomeFormation.toString().trim()

        //        val _RedCard        = getDataList(data[0].mHomeRedCards)
        //        val _YellowCard     = getDataList(data[0].mHomeYellowCards)


        setToTextDetails(home_Formation, tv_away_formation)
        setToTextDetails(home_GoalDetails, tv_home_goal_details)
        setToTextDetails(home_Shot, tv_home_shots)
        setToTextDetails(home_GoalKeeper, tv_home_goalKeeper)
        setToTextDetails(home_Defense, tv_home_defense)
        setToTextDetails(home_Midfield, tv_home_midfield)
        setToTextDetails(home_Forward, tv_home_forward)
        setToTextDetails(home_Substitutes, tv_home_substitutes)
        //        tv_home_formation.text = getDataString("",home_Formation)


        // =========== AWAY TEAM DATA ============ //
        val away_Formation      = data[0].mAwayFormation.toString().trim()
        val away_GoalDetails    = getDataList(data[0].mAwayGoalDetails)
        val away_Shot           = getDataList(data[0].mAwayShots)
        val away_GoalKeeper     = getDataList(data[0].mAwayLineupGoalkeeper)
        val away_Defense        = getDataList(data[0].mAwayLineupDefense)
        val away_Midfield       = getDataList(data[0].mAwayLineupMid)
        val away_Forward        = getDataList(data[0].mAwayLineupForward)
        val away_Substitutes    = getDataList(data[0].mAwayLineupSubstitutes)

        tv_away_formation.text = getDataString("",away_Formation)
        setToTextDetails(away_GoalDetails, tv_away_goal_details)
        setToTextDetails(away_Shot, tv_away_shots)
        setToTextDetails(away_GoalKeeper, tv_away_goalKeeper)
        setToTextDetails(away_Defense, tv_away_defense)
        setToTextDetails(away_Midfield, tv_away_midfield)
        setToTextDetails(away_Forward, tv_away_forward)
        setToTextDetails(away_Substitutes, tv_away_substitutes)

        hideProgress(progressBar)

    }

    // === Function Menampilkan Team Badge =====
    override fun showHomeTeamBadge(data: List<BadgeDataItem>) {
         Picasso.get().load(data[0].mTeamBadge).into(img_home_badge)
    }

    override fun showAwayTeamBadge(data: List<BadgeDataItem>) {
         Picasso.get().load(data[0].mTeamBadge).into(img_away_badge)
    }

    // === Function String, Get data List & set to Text ===

    private fun getDataString(dataText: String?, value: String): String {
        return if (value != "null")
            getString(R.string.textDetails,dataText, value)
        else
            getString(R.string.textDetails, ""," - ")
    }

    private fun getDataList (data: String?): List<String> {
        return data.toString().split(";")
    }

    private fun setToTextDetails(listData: List<String> , tv: TextView ){
        for (value in listData) {
            tv.text = getDataString(tv.text.toString(), value.trim() )
        }
    }


}
