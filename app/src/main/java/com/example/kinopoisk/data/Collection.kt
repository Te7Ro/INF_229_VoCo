package com.example.kinopoisk.data

data class Collection (
    val total : Int,
    val totalPages : Int,
    val items : List<MovieCollection>
)