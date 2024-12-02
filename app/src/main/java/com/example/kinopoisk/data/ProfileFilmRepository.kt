package com.example.kinopoisk.data

class ProfileFilmRepository(private val dao: ProfileFilmDao){
    suspend fun getFilmsByCategory(category: String): List<ProfileFilm> = dao.getFilmsByCategory(category)
    suspend fun addFilm(film: ProfileFilm) = dao.insertFilm(film)
    suspend fun removeFilm(film: ProfileFilm) = dao.deleteFilm(film)
}