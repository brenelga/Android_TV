package com.example.nefis.modelo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(
    val title: String,
    val category: String,
    val cardImageUrl: Int,
    val description: String,
    val videoUrl: Int
) : Parcelable