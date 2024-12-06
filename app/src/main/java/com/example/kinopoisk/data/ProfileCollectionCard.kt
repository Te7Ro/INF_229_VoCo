package com.example.kinopoisk.data

import com.example.kinopoisk.database.ProfileFilm

data class ProfileCollectionCard(
    val title: String,
    val icon: Int,
    val films: List<Int>
)