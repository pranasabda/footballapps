package com.prana.footballapps.view

import android.widget.ProgressBar
import com.prana.footballapps.model.TeamDataItem

interface DetailTeamView {
    fun showProgress(progressBar: ProgressBar)

    fun hideProgress(progressBar: ProgressBar)

    fun showDetailTeam (data : List<TeamDataItem>)

}