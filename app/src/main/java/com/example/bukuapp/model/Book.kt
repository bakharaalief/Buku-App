package com.example.bukuapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    val title : String,
    val urlCover : String,
    val author : String,
) : Parcelable
