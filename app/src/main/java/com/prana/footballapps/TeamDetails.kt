package com.prana.footballapps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
// import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

//Penerapan Anko Layout

class TeamDetails : AppCompatActivity() {

    companion object {
        const val TEAM_NAME              = "name"
        const val TEAM_IMAGE             = "image"
        const val TEAM_DESCRIPTION       = "description"
    }
    private var team_name:           String  = ""
    private var team_image:          Int     = 0
    private var team_description:    String  = ""

    lateinit var name_tv    : TextView
    lateinit var image_iv   : ImageView
    lateinit var  desc_tv   : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TeamDetailsUI().setContentView(this)

        verticalLayout {
            padding = dip(18)

            image_iv = imageView()
                    .lparams(width = dip(100),
                            height = wrapContent) {
                        gravity = Gravity.CENTER
                    }

            name_tv = textView()
                    .lparams(width = wrapContent) {
                        gravity = Gravity.CENTER
                        topMargin = dip(12)
                    }

            desc_tv = textView()
                    .lparams(width = wrapContent) {
                        margin = dip(20)
//                        topMargin = dip(20)
//                        leftMargin = dip(20)
//                        rightMargin = dip(20)
                    }
        }

        team_name        = intent.getStringExtra(TEAM_NAME)
        team_image       = intent.getIntExtra(TEAM_IMAGE,0)
        team_description = intent.getStringExtra(TEAM_DESCRIPTION)

        name_tv.text = team_name
        Glide.with(image_iv).load(team_image).into(image_iv)
        desc_tv.text = team_description

    }

}