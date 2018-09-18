package com.prana.footballapps.view

import com.prana.footballapps.model.MatchDataItem

// Interface View untuk Match
interface MatchEventView {

    fun showProgress()

    fun hideProgress()

    fun showDataMatchList(data: List<MatchDataItem>)
}