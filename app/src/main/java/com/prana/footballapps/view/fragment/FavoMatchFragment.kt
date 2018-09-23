package com.prana.footballapps.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.prana.footballapps.R
import com.prana.footballapps.adapter.FavoriteMatchAdapter
import com.prana.footballapps.database.FavoriteMatch
import com.prana.footballapps.database.database
import com.prana.footballapps.view.DetailMatchEventActivity
import kotlinx.android.synthetic.main.fragment_favo_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh

class FavoMatchFragment : Fragment() {

    private var favoriteMatch : MutableList<FavoriteMatch> = mutableListOf()
    private lateinit var adapter: FavoriteMatchAdapter
    private lateinit var listMatch :RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = FavoriteMatchAdapter(favoriteMatch){
            ctx.startActivity<DetailMatchEventActivity>("id_event" to "${it.idEvent}",
                                                        "home_team" to "${it.homeTeam}",
                                                        "home_score" to "${it.homeScore}",
                                                        "home_score" to "${it.homeScore}",
                                                        "away_team" to "${it.awayTeam}",
                                                        "away_score" to "${it.awayScore}",
                                                        "away_score" to "${it.awayScore}",
                                                        "date_event" to "${it.dateEvent}")
        }

//        listMatch.layoutManager = LinearLayoutManager(ctx);

        listMatch = rv_fav_match
        listMatch.layoutManager = LinearLayoutManager(ctx)

        listMatch.adapter = adapter
        showFavoriteMatch()

        fav_swipe_refresh.onRefresh {
            favoriteMatch.clear()
            showFavoriteMatch()
        }

    }

    private fun showFavoriteMatch() {
        context?.database?.use {
            fav_swipe_refresh.isRefreshing = false
            val result = select(FavoriteMatch.TABLE_FAV_MATCH)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            favoriteMatch.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favo_match, container, false)
    }
}
