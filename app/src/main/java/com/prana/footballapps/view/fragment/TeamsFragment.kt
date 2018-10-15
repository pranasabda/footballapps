package com.prana.footballapps.view.fragment


import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
//import android.support.v7.widget.SearchView  // Perhatikan harus sama dengan Recyclerview dan onQuesyTextListener support.v7
import android.view.*
import android.widget.*
import com.google.gson.Gson

import com.prana.footballapps.R
import com.prana.footballapps.R.id.search_team
import com.prana.footballapps.adapter.TeamAdapter
import com.prana.footballapps.api.ApiRequest
import com.prana.footballapps.model.TeamDataItem
import com.prana.footballapps.presenter.TeamPresenter
import com.prana.footballapps.view.DetailTeamActivity
import com.prana.footballapps.view.TeamDetails
import com.prana.footballapps.view.TeamView
import kotlinx.android.synthetic.main.fragment_teams.*
//import org.jetbrains.anko.appcompat.v7.coroutines.onQueryTextListener
import org.jetbrains.anko.sdk25.coroutines.onQueryTextListener
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh


class TeamsFragment : Fragment(), TeamView {

    // Menerapkan Presente dan adapter
    private var teamDataList        : MutableList<TeamDataItem> = mutableListOf()
    private lateinit var presenter  : TeamPresenter
    private lateinit var adapter    : TeamAdapter

    private lateinit var recyclerViewTeam : RecyclerView
    private lateinit var progressBar : ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var spinner: Spinner
    private lateinit var league : String
    private var searchView : SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progressBar = progress_bar_teams
        swipeRefreshLayout = swipe_refresh_teams
        spinner = spinner_teams

        // Setting SpinnerAdapter
        val spinnerItems = resources.getStringArray(R.array.league)
        val spinnerAdapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        spinner.adapter = spinnerAdapter

        // Spinner onClick
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                league = spinner.selectedItem.toString()
                presenter.getTeamListData(league)
            }
        }

        adapter = TeamAdapter(teamDataList){

            // Menggunakan : import org.jetbrains.anko.startActivity
            // ctx.startActivity<TeamDetails>("id" to "${it.mIdTeam}") // Spesifik hanya id
            ctx.startActivity<DetailTeamActivity>("team_data" to it ) // it semua isi TeamDataItem (harus parcelize)
        }

        recyclerViewTeam = recyclerview_teams
        recyclerViewTeam.layoutManager = LinearLayoutManager(ctx)

        recyclerViewTeam.adapter = adapter

        // Deklarasi untuk presenter
        val request = ApiRequest()
        val gson = Gson()
        presenter = TeamPresenter(this, request, gson)

        // showTeamListData()

        swipeRefreshLayout.onRefresh {
            presenter.getTeamListData(league)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun showloading() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        progressBar.visibility = View.VISIBLE
    }

    override fun hideloading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        progressBar.visibility = View.GONE
    }

    override fun showTeamListData(data: List<TeamDataItem>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        swipeRefreshLayout.isRefreshing = false
        teamDataList.clear()
        teamDataList.addAll(data)
        adapter.notifyDataSetChanged()
        hideloading()
    }

    // Membuat Menu untuk Pencarian Team dengan SearchView & QueryTextListener
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {

        menu?.clear()
        inflater?.inflate(R.menu.search_team, menu)
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.search_team)

        // Perhatikan import widget harus sama dengan Recyclerview e.q :
        searchView = searchItem?.actionView as SearchView
        searchView?.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView?.setIconifiedByDefault(false)
        searchView?.queryHint = "Search Team..."
        searchView?.onQueryTextListener {
            onQueryTextChange { it ->
                presenter.getSearchTeamData(it)
                true
            }
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            search_team -> {
              true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
