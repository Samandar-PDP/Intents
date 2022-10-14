package com.example.intentsnew.model

import java.io.Serializable

data class User(
    val name: String,
    val lastName: String,
    val age: Int,
    val id: Int
): Serializable
// Serializable
// Parcelable