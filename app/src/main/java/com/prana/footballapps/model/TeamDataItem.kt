package com.prana.footballapps.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*
* Note menggunakan Parcel harus aktifkan
* androidExtensions { experimental = true} --> pada build.gradle level app
* Ref : https://www.dicoding.com/academies/55/tutorials/1565?from=1573
* */

@Parcelize // Anotasi @Parcelize --> untuk mengguanakan Parcel Anko Extension. Ref: https://www.dicoding.com/academies/55/tutorials/1565?from=1573
data class TeamDataItem (val teamName: String, val teamImage: Int,
                         val teamDescription: String) : Parcelable