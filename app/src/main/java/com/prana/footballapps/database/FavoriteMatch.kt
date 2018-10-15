package com.prana.footballapps.database

data class FavoriteMatch(val id: Long?,
                         val idEvent: String?,
                         val dateEvent: String?,
                         val homeTeam: String?,
                         val awayTeam: String?,
                         val homeScore: String?,
                         val awayScore: String?,
                         val homeGoalDetails: String?,
                         val awayGoalDetails: String?,
                         val time: String?){

    companion object {
        const val TABLE_FAV_MATCH: String = "TABLE_FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val ID_EVENT = "ID_EVENT"
        const val DATE_EVENT = "DATE_EVENT"
        const val HOME_TEAM = "HOME_TEAM"
        const val HOME_SCORE = "HOME_SCORE"
        const val HOME_GOAL_DETAIL = "HOME_GOAL_DETAIL"
        const val AWAY_TEAM = "AWAY_TEAM"
        const val AWAY_SCORE = "AWAY_SCORE"
        const val AWAY_GOAL_DETAIL = "AWAY_GOAL_DETAIL"
        const val TIME_EVENT = "TIME_EVENT"

        //const val TABLE_FAV_TEAM: String = "TABLE_FAVORITE_TEAM"
        //const val ID_DB: String = "ID_DB_"
        //const val ID_TEAM = "ID_TEAM"
        //const val IMAGE_TEAM = "IMAGE_TEAM"
        //const val NAME_TEAM = "NAME_TEAM"
    }
}