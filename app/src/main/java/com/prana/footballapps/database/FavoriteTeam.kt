package com.prana.footballapps.database

//data class FavoriteTeam (val id: Long?,
//                         val idTeam: String?,
//                         val nameTeam: String?,
//                         val imageTeam: String?,
//                         val yearTeam: String?,
//                         val stadiumTeam: String?,
//                         val descTeam: String?) {

class FavoriteTeam {

    companion object {
        const val TABLE_FAV_TEAM: String = "TABLE_FAVORITE_TEAM"
        const val ID: String = "ID_"
        const val ID_TEAM: String = "ID_TEAM"
        const val NAME_TEAM: String = "NAME_TEAM"
        const val IMAGE_TEAM: String = "IMAGE_TEAM"
        const val YEAR_TEAM: String = "YEAR_TEAM"
        const val STADIUM_TEAM: String = "STADIUM_TEAM"
        const val STADIUM_THUMB: String = "STADIUM_THUMB"
        const val FANART1_TEAM: String = "FANART1_TEAM"
        const val FANART2_TEAM: String = "FANART2_TEAM"
        const val DESC_TEAM: String = "DESC_TEAM"
    }

}