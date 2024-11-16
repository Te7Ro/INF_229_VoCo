package com.example.kinopoisk.data

data class MovieActor(
    val items: List<ActorShort>
)

data class ActorShort(
    val staffId: Int,
    val nameRu: String,
    val nameEn: String,
    val description: String,
    val posterUrl: String,
    val professionText: String,
    val professionKey: String
)

data class ActorDetailed(
    val personId: Int,
    val webUrl: String,
    val nameRu: String,
    val nameEn: String,
    val sex: String,
    val posterUrl: String,
    val growth: String,
    val birthday: String,
    val death: String,
    val age: Int,
    val birthplace: String,
    val deathplace: String,
    val hasAwards: Int,
    val profession: String,
    val facts: List<String>,
    val spouses: List<Spouse>,
    val films: List<Film>
)

data class Spouse(
    val personId: Int,
    val name: String,
    val divorced: Boolean,
    val divorcedReason: String,
    val sex: String,
    val children: Int,
    val webUrl: String,
    val relation: String
)

data class Film(
    val filmId: Int,
    val nameRu: String,
    val nameEn: String,
    val rating: String,
    val general: Boolean,
    val description: String,
    val professionKey: String
)