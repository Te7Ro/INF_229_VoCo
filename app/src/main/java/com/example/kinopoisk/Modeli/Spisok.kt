package com.example.kinopoisk.Modeli

import com.example.kinopoisk.R

data class Items(
    val Name: String,
    val Genre: String,
    val Image: Int = R.drawable.img,
    val Rating: String,
) {
}

data class Spisok(
    val Title: String,
    val Items: List<Items>

)