package com.prana.footballapps.view.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
// import android.support.v4.app.FragmentManager
import android.view.*

import com.prana.footballapps.R
import com.prana.footballapps.adapter.MatchPagerAdapter
import com.prana.footballapps.view.SearchEventActivity
import kotlinx.android.synthetic.main.fragment_match.*
import org.jetbrains.anko.support.v4.startActivity

class ParentMatchFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setHasOptionsMenu(true)

        //val mMatchPagerAdapter = MatchPagerAdapter(childFragmentManager)
        viewpager_match.adapter = MatchPagerAdapter(childFragmentManager)
        tabs_match.setupWithViewPager(viewpager_match)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    // Set untuk menampilkan menu search event / search match
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        menu?.clear()
        inflater?.inflate(R.menu.search_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.search_menu_id -> {
                startActivity<SearchEventActivity>()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
