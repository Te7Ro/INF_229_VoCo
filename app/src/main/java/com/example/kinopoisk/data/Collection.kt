package com.example.kinopoisk.data

data class Collection (
    val total : Int,
    val totalPages : Int,
    val items : List<Movie>
)

data class Movie(
    val kinopoiskId : Int,
    val nameRu : String,
    val nameEn : String,
    val nameOriginal : String,
    val countries : List<Country>,
    val genres : List<Genre>,
    val ratingKinopoisk : Double,
    val ratingImdb : Double,
    val year : String,
    val type : String,
    val posterUrl : String,
    val posterUrlPreview : String,
)

data class Country(
    val country : String
)

data class Genre(
    val genre : String
)