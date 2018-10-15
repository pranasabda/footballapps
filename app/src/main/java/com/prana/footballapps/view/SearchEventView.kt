package com.prana.footballapps.view

import com.prana.footballapps.model.EventDataItem

interface SearchEventView {
    fun showProgress()
    fun hideProgress()
    fun showListEvent(event: List<EventDataItem>)
}