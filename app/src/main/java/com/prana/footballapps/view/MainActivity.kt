package com.prana.footballapps.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.prana.footballapps.R
import com.prana.footballapps.R.array.*
import com.prana.footballapps.adapter.TeamAdapter
import com.prana.footballapps.model.TeamDataItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.startActivity


// CATATAN : Untuk Submission 2 - 5 (final project) kelas MainActivity tidak digunakan.
class MainActivity : AppCompatActivity() {


    private var teamDataItems: MutableList<TeamDataItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Penerapan Anko Common Dialog
        val progressDialog = indeterminateProgressDialog("Getting Data! Please wait...")

        // Penerapan Anko Common Dialog
        progressDialog.show()

        // inisiasi data
        initData()

        progressDialog.dismiss()

        //team_list_rv.layoutManager = LinearLayoutManager(this)
        //team_list_rv.adapter = TeamAdapter(this, teamDataItems) { itemClicked(it)}
    }

    private fun itemClicked(itemData: TeamDataItem) {
        startActivity<TeamDetails>(TeamDetails.TEAM_NAME to itemData.mTeamName,
                                    TeamDetails.TEAM_IMAGE to itemData.mTeamBadge,
                                    TeamDetails.TEAM_DESCRIPTION to itemData.mTeamDescription )
    }

    private fun initData() {
        val teamName    = resources.getStringArray(club_name) // rebuild project jika Resource tidak terbaca (karena kita memodifikasi string.xml)
        val teamImage   = resources.obtainTypedArray(club_image)
        val teamDesc    = resources.getStringArray(club_description)

        teamDataItems.clear()

//        for (i in teamName.indices) {
//            teamDataItems.add(TeamDataItem(teamName[i],
//                    teamImage.getResourceId(i,0), teamDesc[i]))
//        }
        //Recycle tipe array
        teamImage.recycle()
    }
}
