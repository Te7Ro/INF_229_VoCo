package com.example.kinopoisk.data

data class ProfileCollectionCard(
    val title: String,
    val icon: Int,
    val films: List<ProfileFilm>
)