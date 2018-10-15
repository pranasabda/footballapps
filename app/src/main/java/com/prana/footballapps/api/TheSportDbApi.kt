package com.prana.footballapps.api

import android.net.Uri
import android.os.Build
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

    // function untuk mengambil data Team berdasarkan nama liga
    // https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League
    fun getTeams(league: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("search_all_teams.php")
                .appendQueryParameter("l", league) // Huruf L bukan 1
                .build().toString()
    }

    // function untuk mengambil detail teams
    fun getTeamDetail (idTeam: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("lookupteam.php")
                .appendQueryParameter("id", idTeam)
                .build().toString()
    }

    // function untuk mengambil data Pemain/player berdasarkan id Team
    // https://www.thesportsdb.com/api/v1/json/1/lookup_all_players.php?id=133604
    fun getPlayers(idTeam: String?): String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("lookup_all_players.php")
                .appendQueryParameter("id", idTeam)
                .build().toString()
    }

    // function untuk pencarian pertandingan berdasarkan nama team
    // https://www.thesportsdb.com/api/v1/json/1/searchevents.php?e=Arsenal_vs_Chelsea
    fun getSearchMatches(teamName: String?): String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("searchevents.php")
                .appendQueryParameter("e", teamName)
                .build().toString()
    }

    // function untuk pencarian team berdasarkan nama team
    // https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t=Arsenal
    fun getSearchTeams(teamName: String?): String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("searchteams.php")
                .appendQueryParameter("t", teamName)
                .build().toString()
    }

}