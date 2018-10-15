package com.prana.footballapps.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayerDataItem(

        @SerializedName("idTeam")
        var mIdTeam: String? = null,

        @SerializedName("strPlayer")
        var mNamePlayer: String? = null,

        @SerializedName("strDescriptionEN")
        var mDescriptionEN: String? = null,

        @SerializedName("strPosition")
        var mPosition: String? = null,

        @SerializedName("strWeight")
        var mWeight: String? = null,

        @SerializedName("strHeight")
        var mHeight: String? = null,

        @SerializedName("strCutout")
        var mCutOut: String? = null,

        @SerializedName("strFanart1")
        var mFanArt1: String? = null) : Parcelable