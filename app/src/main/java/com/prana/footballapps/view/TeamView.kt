package com.prana.footballapps.view

import com.prana.footballapps.model.TeamDataItem

interface TeamView {
    fun showloading()
    fun hideloading()
    fun showTeamListData(data: List<TeamDataItem>)
}