package com.example.intentsnew.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val lastName: String,
    val age: Int
): Parcelable
