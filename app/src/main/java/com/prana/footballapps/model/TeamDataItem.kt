package com.prana.footballapps.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/*
* Note menggunakan Parcel harus aktifkan
* androidExtensions { experimental = true} --> pada build.gradle level app
* Ref : https://www.dicoding.com/academies/55/tutorials/1565?from=1573
* */

/*
@Parcelize // Anotasi @Parcelize --> untuk mengguanakan Parcel Anko Extension. Ref: https://www.dicoding.com/academies/55/tutorials/1565?from=1573
data class TeamDataItem (val teamName: String, val teamImage: Int,
                         val teamDescription: String) : Parcelable
*/

// Untuk Final Project, yang di atas untuk submission 1 (comment).
@Parcelize
data class TeamDataItem(
                        val id: Long?,

                        @SerializedName("idTeam")
                        var mIdTeam: String? = null,

                        @SerializedName("strTeam")
                        var mTeamName: String? = null,

                        @SerializedName("strTeamBadge")
                        var mTeamBadge: String? = null,

                        @SerializedName("intFormedYear")
                        var mTeamFormedYear: String? = null,

                        @SerializedName("strStadium")
                        var mTeamStadium: String? = null,

                        @SerializedName("strStadiumThumb")
                        var mStadiumThumb: String? = null,

                        @SerializedName("strTeamFanart1")
                        var mTeamFanArt1: String? = null,

                        @SerializedName("strTeamFanart2")
                        var mTeamFanArt2: String? = null,

                        @SerializedName("strDescriptionEN")
                        var mTeamDescription: String? = null ) : Parcelable

