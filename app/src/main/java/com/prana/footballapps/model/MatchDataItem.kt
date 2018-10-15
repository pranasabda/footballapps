package com.prana.footballapps.model

//import javax.annotation.Generated
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

// POJO Disusun Sesuai Tampilan
//@Generated("com.robohorse.robopojogenerator")
@Parcelize
data class MatchDataItem (
        // POJO Disusun Sesuai Tampilan
        @SerializedName("idEvent")
        var mIdEvent: String? = null,

        @SerializedName("dateEvent")
        var mDateEvent: String? = null,

        // -- HOME TEAM --
        @SerializedName("strHomeTeam")
        var mHomeTeam: String? = null,

        @SerializedName("intHomeScore")
        var mHomeScore: String? = null,

        @SerializedName("strHomeGoalDetails") // X
        val mHomeGoalDetails: String? = null,

        // -- AWAY TEAM --
        @SerializedName("strAwayTeam")
        var mAwayTeam: String? = null,

        @SerializedName("intAwayScore")
        var mAwayScore: String? = null,

        @SerializedName("strAwayGoalDetails") // X
        val mAwayGoalDetails: String? = null,

        @SerializedName("strTime")
        var mTime: String? = null
):Parcelable