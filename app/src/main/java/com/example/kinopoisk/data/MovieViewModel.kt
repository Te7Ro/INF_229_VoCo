package com.example.kinopoisk.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface MovieScreenState {
    object Initial : MovieScreenState
    object Loading : MovieScreenState
    data class Error(val message: String) : MovieScreenState
    data class Success(val movieDetailed: MovieDetailed) : MovieScreenState
}

class MovieViewModel : ViewModel(){
    private val _screenState = MutableStateFlow<MovieScreenState>(MovieScreenState.Initial)
    val screenState : StateFlow<MovieScreenState> = _screenState

    fun fetchMovie(id: Int){
        _screenState.update { MovieScreenState.Loading }
        viewModelScope.launch {
            try {
                val response = KinopoiskApi.api.getMovie(id)
                _screenState.update { MovieScreenState.Success(response) }
            } catch (e : Exception){
                _screenState.update { MovieScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}


