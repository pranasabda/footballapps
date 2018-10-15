package com.prana.footballapps.view

import com.prana.footballapps.model.PlayerDataItem

interface PlayerView {
    fun showProgress()
    fun hideProgress()
    fun showPlayerListData(data: List<PlayerDataItem>)
}