package com.prana.footballapps.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.prana.footballapps.model.TeamDataItem
import org.jetbrains.anko.db.*

class FootballDatabaseHelper(ctx: Context) :
        ManagedSQLiteOpenHelper(ctx, "FootballApp.db",null,1){

    companion object {
        private  var instance: FootballDatabaseHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): FootballDatabaseHelper{
            if (instance == null) {
                instance = FootballDatabaseHelper(ctx.applicationContext)
            }
            return instance as FootballDatabaseHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(FavoriteMatch.TABLE_FAV_MATCH,true,
                FavoriteMatch.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteMatch.ID_EVENT to TEXT + UNIQUE,
                FavoriteMatch.DATE_EVENT to TEXT,
                FavoriteMatch.HOME_TEAM to TEXT,
                FavoriteMatch.AWAY_TEAM to TEXT,
                FavoriteMatch.HOME_SCORE to TEXT,
                FavoriteMatch.AWAY_SCORE to TEXT,
                FavoriteMatch.HOME_GOAL_DETAIL to TEXT,
                FavoriteMatch.AWAY_GOAL_DETAIL to TEXT,
                FavoriteMatch.TIME_EVENT to TEXT)

        db.createTable(FavoriteTeam.TABLE_FAV_TEAM, true,
                FavoriteTeam.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteTeam.ID_TEAM to TEXT + UNIQUE,
                FavoriteTeam.NAME_TEAM to TEXT,
                FavoriteTeam.IMAGE_TEAM to TEXT,
                FavoriteTeam.YEAR_TEAM to TEXT,
                FavoriteTeam.STADIUM_TEAM to TEXT,
                FavoriteTeam.STADIUM_THUMB to TEXT,
                FavoriteTeam.FANART1_TEAM to TEXT,
                FavoriteTeam.FANART2_TEAM to TEXT,
                FavoriteTeam.DESC_TEAM to TEXT
                )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteMatch.TABLE_FAV_MATCH,true)
        db.dropTable(FavoriteTeam.TABLE_FAV_TEAM, true)
    }

}
// Akses properti database untuk context
val Context.database: FootballDatabaseHelper
    get() = FootballDatabaseHelper.getInstance(applicationContext)