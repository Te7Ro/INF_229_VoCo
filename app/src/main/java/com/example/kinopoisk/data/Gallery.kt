package com.example.kinopoisk.data

data class Gallery(
    val total: Int,
    val totalPages: Int,
    val items: List<Photo>
)

data class Photo(
    val imageUrl: String,
    val previewUrl: String
)