package com.prana.footballapps.view.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.prana.footballapps.R
import com.prana.footballapps.adapter.FavoriteTeamAdapter
import com.prana.footballapps.database.FavoriteTeam
import com.prana.footballapps.database.database
import com.prana.footballapps.model.TeamDataItem
import com.prana.footballapps.view.DetailTeamActivity
import kotlinx.android.synthetic.main.fragment_favorite_teams.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh

class FavoriteTeamsFragment : Fragment() {

    private var favoriteTeam : MutableList<TeamDataItem> = mutableListOf()
    private lateinit var adapter: FavoriteTeamAdapter
    private lateinit var rvTeam : RecyclerView
    private lateinit var swipeRefresh : SwipeRefreshLayout

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = FavoriteTeamAdapter(favoriteTeam){
            ctx.startActivity<DetailTeamActivity>("team_data" to it)
        }

        rvTeam = rv_fav_team
        rvTeam.layoutManager = LinearLayoutManager(ctx)
        rvTeam.adapter = adapter
        showFavoriteTeam()

        fav_team_swipe_refresh.onRefresh {
            favoriteTeam.clear()
            showFavoriteTeam()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_teams, container, false)
    }

    private fun showFavoriteTeam() {
        context?.database?.use {
            fav_team_swipe_refresh.isRefreshing = false
            val result = select(FavoriteTeam.TABLE_FAV_TEAM)
            val favorite = result.parseList(classParser<TeamDataItem>())
            favoriteTeam.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }

}
