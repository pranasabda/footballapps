package com.prana.footballapps.api

import android.net.Uri
import com.prana.footballapps.BuildConfig

object TheSportDbApi {

    // function untuk mengambil data Prev Match
    fun getPrevMatch(league: String? = "4335"): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("eventspastleague.php")
                .appendQueryParameter("id",league)
                .build()
                .toString()
    }

    // function untuk mengambil data Next Match
    fun getNextMatch(league: String? = "4335"): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("eventsnextleague.php")
                .appendQueryParameter("id",league)
                .build().toString()
    }

    // function untuk mengambil data Detail Match
    fun getDetailMatch(event: String? = ""): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("lookupevent.php")
                .appendQueryParameter("id",event)
                .build().toString()
    }

    // function untuk mengambil data Badge URL
    fun getBadge(badgeTeam: String? = ""): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("searchteams.php")
                .appendQueryParameter("t",badgeTeam)
                .build().toString()
    }
}