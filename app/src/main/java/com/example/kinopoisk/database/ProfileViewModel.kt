package com.example.kinopoisk.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.di.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: ProfileRepository) : ViewModel() {

    private val _collections = MutableStateFlow<Resource<List<ProfileFilm>>>(Resource.Initial)
    val collections = _collections.asStateFlow()

    init {
        fetchFilmsByCategory()
    }

    private fun fetchFilmsByCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFilms().collect { result ->
                _collections.value = result
            }
        }
    }
    fun insertFilm(profileFilm: ProfileFilm) {
        viewModelScope.launch {
            repository.insertFilm(profileFilm)
        }
    }
}