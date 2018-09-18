package com.prana.footballapps.view

import android.widget.ProgressBar
import com.prana.footballapps.model.BadgeDataItem
import com.prana.footballapps.model.DetailMatchDataItem
import com.prana.footballapps.model.MatchDataItem

interface DetailMatchEventView {

    fun showProgress(progressBar: ProgressBar)

    fun hideProgress(progressBar: ProgressBar)

    fun showDetailMatch (data : List<DetailMatchDataItem>)

    fun showHomeTeamBadge (data: List<BadgeDataItem>)

    fun showAwayTeamBadge (data: List<BadgeDataItem>)

}