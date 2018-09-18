package com.prana.footballapps.model

import com.google.gson.annotations.SerializedName

data class BadgeDataItem (
        @SerializedName("strTeamBadge")
        val mTeamBadge: String? = ""
)