package com.prana.footballapps.view

import android.database.sqlite.SQLiteConstraintException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import com.prana.footballapps.R
import com.prana.footballapps.adapter.TeamDetailPagerAdapter
import com.prana.footballapps.database.FavoriteMatch
import com.prana.footballapps.database.FavoriteTeam
import com.prana.footballapps.database.database
import com.prana.footballapps.model.TeamDataItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match_event.*
import kotlinx.android.synthetic.main.activity_detail_team.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.design.snackbar

class DetailTeamActivity : AppCompatActivity() {

    // Menu Fav & Add Data for Favorite
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false

    private lateinit var teamData: TeamDataItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        teamData = intent.getParcelableExtra("team_data")

        favoriteState()

        //linear_background.setBackgroundResource(Picasso.get().load(teamData.mTeamFanArt1).into())
        // Picasso.get().load(teamData.mTeamFanArt1).into(img_team_detail)

        Picasso.get().load(teamData.mTeamBadge).into(img_team_detail)
        // tv_team_name_detail.text = teamData.mTeamName // diclose karena menggunakan tilte dari collapsing toolbar
        tv_team_year_detail.text = teamData.mTeamFormedYear
        tv_team_stadium_detail.text = teamData.mTeamStadium

        // Diclose karena gambar
        if (teamData.mStadiumThumb.isNullOrEmpty()){
            img_background_detail.setImageResource(R.drawable.soccer_field_camp)
        } else {
            Picasso.get().load(teamData.mStadiumThumb).into(img_background_detail)
        }


        // kotlin Viewpager in activity : https://www.raywenderlich.com/324-viewpager-tutorial-getting-started-in-kotlin
        viewpager_team_detail.adapter = TeamDetailPagerAdapter(supportFragmentManager, teamData.mTeamDescription, teamData.mIdTeam)
        tabs_team_detail.setupWithViewPager(viewpager_team_detail)

        setSupportActionBar(toolbar_team_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = teamData.mTeamName
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        super.onBackPressed()
//        return super.onOptionsItemSelected(item)
//    }


    // Membuat Favorite menu pada toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuInflater.inflate(detail)
        menuInflater.inflate(R.menu.detail_fav_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
    }

    // fungsi add & remove dan set icon favorite pada saat menu fav di click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            android.R.id.home -> {
                super.onBackPressed()
                true }

            R.id.add_to_favorite -> {
                if (isFavorite)  removeToFavorite() else addToFavorite()

                isFavorite = !isFavorite
                setFavorite()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addToFavorite() {

        // Log.d("Debug", "Add")

        try {
            database.use {
                insert(FavoriteTeam.TABLE_FAV_TEAM,
                        FavoriteTeam.ID_TEAM to teamData.mIdTeam,
                        FavoriteTeam.NAME_TEAM to teamData.mTeamName,
                        FavoriteTeam.IMAGE_TEAM to teamData.mTeamBadge,
                        FavoriteTeam.YEAR_TEAM to teamData.mTeamFormedYear,
                        FavoriteTeam.STADIUM_TEAM to teamData.mTeamStadium,
                        FavoriteTeam.STADIUM_THUMB to teamData.mStadiumThumb,
                        FavoriteTeam.FANART1_TEAM to teamData.mTeamFanArt1,
                        FavoriteTeam.FANART2_TEAM to teamData.mTeamFanArt2,
                        FavoriteTeam.DESC_TEAM to teamData.mTeamDescription)


            }
            snackbar(detail_activity, "Added to Your Favorite Team").show()
        }catch (e: SQLiteConstraintException){
            snackbar(detail_activity, e.localizedMessage).show()
        }
    }

    private fun removeToFavorite() {

        // Log.d("Debug", "Remove")

        try {
            database.use {
                delete(FavoriteTeam.TABLE_FAV_TEAM, "( ID_TEAM = {id_team} )",
                        "id_team" to teamData.mIdTeam.toString())
            }
            snackbar(detail_activity, "Remove From Favorite Team").show()
        }catch (e: SQLiteConstraintException){
            snackbar(detail_activity, e.localizedMessage).show()
        }
    }

    // Jika ada error : SQLiteException Caused by: android.database.sqlite.SQLiteException:
    // no such table: TABLE_FAV_TEAM (code 1):
    // Uninstall dulu appnya yang di emulator.

    // Membuat Status/State Favorite
    private fun favoriteState(){
        database.use {
            val result = select(FavoriteTeam.TABLE_FAV_TEAM)
                    .whereArgs("( ID_TEAM = {id_team})",
                    "id_team" to teamData.mIdTeam.toString() )
            val favoriteTeam = result.parseList(classParser<TeamDataItem>())
            if (!favoriteTeam.isEmpty()) isFavorite = true
        }
    }
}
