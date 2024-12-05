package com.example.kinopoisk.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: ProfileFilmRepository) : ViewModel() {

    private val _watchedFilms = MutableStateFlow<List<ProfileFilm>>(emptyList())
    val watchedFilms: StateFlow<List<ProfileFilm>> get() = _watchedFilms

    private val _likedFilms = MutableStateFlow<List<ProfileFilm>>(emptyList())
    val likedFilms: StateFlow<List<ProfileFilm>> get() = _likedFilms

    private val _favoriteFilms = MutableStateFlow<List<ProfileFilm>>(emptyList())
    val favoriteFilms: StateFlow<List<ProfileFilm>> get() = _favoriteFilms

    private val _customFilms = MutableStateFlow<List<ProfileFilm>>(emptyList())
    val customFilms: StateFlow<List<ProfileFilm>> get() = _customFilms

    fun loadFilms(){
        viewModelScope.launch {
            _watchedFilms.update { repository.getFilmsByCategory("Просмотрено") }
            _likedFilms.update { repository.getFilmsByCategory("Любимые") }
            _favoriteFilms.update { repository.getFilmsByCategory("Посмотреть") }
            _customFilms.update { repository.getFilmsByCategory("Свои") }
        }
    }

    fun addFilm(film: ProfileFilm){
        viewModelScope.launch {
            repository.addFilm(film)
            loadFilms()
        }
    }

    fun deleteFilm(film: ProfileFilm){
        viewModelScope.launch {
            repository.removeFilm(film)
            loadFilms()
        }
    }

}