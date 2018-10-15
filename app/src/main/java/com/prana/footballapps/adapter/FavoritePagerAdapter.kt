package com.prana.footballapps.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.prana.footballapps.view.fragment.FavoriteMatchesFragment
import com.prana.footballapps.view.fragment.FavoriteTeamsFragment

class FavoritePagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return when(position) {
            0 -> FavoriteMatchesFragment()
            1 -> FavoriteTeamsFragment()
            else -> null

        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Matches"
            1 -> "Teams"
            else -> null
        }
    }
}