package com.prana.footballapps.model

//import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

//@Generated("com.robohorse.robopojogenerator")
data class DetailMatchDataItem(

        @SerializedName("idEvent")
        val idEvent: String? = null,

        @SerializedName("strEvent")
        val strEvent: String? = null,

        @SerializedName("idLeague")
        val idLeague: String? = null,

        @SerializedName("dateEvent")
        val dateEvent: String? = null,

        @SerializedName("strDate")
        val strDate: String? = null,

        @SerializedName("strSport")
        val strSport: String? = null,

        @SerializedName("strCountry")
        val strCountry: Any? = null,

        @SerializedName("idSoccerXML")
        val idSoccerXML: String? = null,

        @SerializedName("strTVStation")
        val strTVStation: Any? = null,

        @SerializedName("strThumb")
        val strThumb: Any? = null,

        @SerializedName("strLeague")
        val strLeague: String? = null,

        @SerializedName("strCity")
        val strCity: Any? = null,

        @SerializedName("strPoster")
        val strPoster: Any? = null,

        @SerializedName("intRound")
        val intRound: String? = null,

        @SerializedName("strMap")
        val strMap: Any? = null,

        @SerializedName("strBanner")
        val strBanner: Any? = null,

        @SerializedName("strFanart")
        val strFanart: Any? = null,

        @SerializedName("strDescriptionEN")
        val strDescriptionEN: Any? = null,

        @SerializedName("strResult")
        val strResult: Any? = null,

        @SerializedName("strCircuit")
        val strCircuit: Any? = null,

        @SerializedName("strFilename")
        val strFilename: String? = null,

        @SerializedName("strTime")
        val strTime: String? = null,

        @SerializedName("strLocked")
        val strLocked: String? = null,

        @SerializedName("strSeason")
        val strSeason: String? = null,

        @SerializedName("intSpectators")
        val intSpectators: Any? = null,


        // ----- HOME TEAM Data Model -------

        @SerializedName("idHomeTeam")
        val mIdHomeTeam: String? = null,

        @SerializedName("strHomeTeam")
        val mHomeTeam: String? = null,

        @SerializedName("strHomeFormation") // v
        val mHomeFormation: String? = null,

        @SerializedName("intHomeScore")
        val mHomeScore: String? = null,

        @SerializedName("strHomeGoalDetails") // v
        val mHomeGoalDetails: String? = null,

        @SerializedName("intHomeShots")
        val mHomeShots: String? = null,

        /// ---- LineUP ---
        @SerializedName("strHomeLineupGoalkeeper") // v
        val mHomeLineupGoalkeeper: String? = null,

        @SerializedName("strHomeLineupDefense") // v
        val mHomeLineupDefense: String? = null,

        @SerializedName("strHomeLineupMidfield") // v
        val mHomeLineupMid: String? = null,

        @SerializedName("strHomeLineupForward") // v
        val mHomeLineupForward: String? = null,

        @SerializedName("strHomeLineupSubstitutes") // v
        val mHomeLineupSubstitutes: String? = null,

        @SerializedName("strHomeYellowCards") // v
        val mHomeYellowCards: String? = null,

        @SerializedName("strHomeRedCards") // v
        val mHomeRedCards: String? = null,


        // ---- AWAYTEAM Data Model ----

        @SerializedName("idAwayTeam")
        val mIdAwayTeam: String? = null,

        @SerializedName("strAwayTeam")
        val mAwayTeam: String? = null,

        @SerializedName("strAwayFormation") // v
        val mAwayFormation: String? = null,

        @SerializedName("intAwayScore")
        val mAwayScore: String? = null,

        @SerializedName("strAwayGoalDetails") // v
        val mAwayGoalDetails: String? = null,

        @SerializedName("intAwayShots")
        val mAwayShots: String? = null,

        /// ---- LineUP ---
        @SerializedName("strAwayLineupGoalkeeper") // v
        val mAwayLineupGoalkeeper: String? = null,

        @SerializedName("strAwayLineupDefense") // v
        val mAwayLineupDefense: String? = null,

        @SerializedName("strAwayLineupMidfield") // v
        val mAwayLineupMid: String? = null,

        @SerializedName("strAwayLineupForward") // v
        val mAwayLineupForward: String? = null,

        @SerializedName("strAwayLineupSubstitutes") // v
        val mAwayLineupSubstitutes: String? = null,

        @SerializedName("strAwayYellowCards") // v
        val mAwayYellowCards: String? = null,

        @SerializedName("strAwayRedCards") // v
        val mAwayRedCards: String? = null

)