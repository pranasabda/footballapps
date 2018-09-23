package com.prana.footballapps.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class FootballDatabaseHelper(ctx: Context) :
        ManagedSQLiteOpenHelper(ctx, "FootballApp.db",null,1){

    companion object {
        private  var instance: FootballDatabaseHelper? = null

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
                FavoriteMatch.AWAY_GOAL_DETAIL to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteMatch.TABLE_FAV_MATCH,true)
    }

}
// Akses properti database untuk context
val Context.database: FootballDatabaseHelper
    get() = FootballDatabaseHelper.getInstance(applicationContext)