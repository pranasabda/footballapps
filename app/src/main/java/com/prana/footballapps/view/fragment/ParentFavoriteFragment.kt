package com.prana.footballapps.view.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.prana.footballapps.R
import com.prana.footballapps.adapter.FavoritePagerAdapter
import kotlinx.android.synthetic.main.fragment_parent_favorite.*


class ParentFavoriteFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setHasOptionsMenu(true)

        viewpager_favorite.adapter = FavoritePagerAdapter(childFragmentManager)
        tabs_favorite.setupWithViewPager(viewpager_favorite)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parent_favorite, container, false)
    }

}
