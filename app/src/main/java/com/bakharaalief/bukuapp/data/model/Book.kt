package com.bakharaalief.bukuapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val title : String,
    val urlCover : String,
    val author : String,
) : Parcelable
