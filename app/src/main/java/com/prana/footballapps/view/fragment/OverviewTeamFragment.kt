package com.prana.footballapps.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.prana.footballapps.R
import com.prana.footballapps.model.TeamDataItem
import kotlinx.android.synthetic.main.fragment_overview_team.*

class OverviewTeamFragment : Fragment() {

    private lateinit var teamData: TeamDataItem


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // teamData = activity?.intent?.getParcelableExtra("team_data")
        // tv_team_overview_detail.text = teamData.mTeamDescription

        teamData = activity?.intent!!.getParcelableExtra("team_data")
        tv_team_overview_detail.text = teamData.mTeamDescription
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview_team, container, false)
    }


}
