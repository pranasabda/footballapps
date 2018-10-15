package com.prana.footballapps.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.prana.footballapps.view.fragment.NextMatchFragment
import com.prana.footballapps.view.fragment.PrevMatchFragment

class MatchPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

//    // list untuk menampung objek Fragment
//    private val pages = listOf(
//            NextMatchFragment(),
//            PrevMatchFragment()
//    )

    override fun getItem(position: Int): Fragment? = when(position) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //return pages[position]
        0 -> PrevMatchFragment()
        1 -> NextMatchFragment()
        else -> null
    }

    override fun getCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return 2
    }

    // title for tabs
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Prev Match"
            1 -> "Next Match"
            else -> null
        }
    }

}