package com.example.kinopoisk.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface MovieActorScreenState {
    object Initial : MovieActorScreenState
    object Loading : MovieActorScreenState
    data class Error(val message: String) : MovieActorScreenState
    data class Success(val movieActor: MovieActor) : MovieActorScreenState
}

class MovieActorViewModel : ViewModel(){
    private val _screenState = MutableStateFlow<MovieActorScreenState>(MovieActorScreenState.Initial)
    val screenState : StateFlow<MovieActorScreenState> = _screenState

    fun fetchMovieActor(id: Int){
        _screenState.update { MovieActorScreenState.Loading }
        viewModelScope.launch {
            try {
                val response = KinopoiskApi.api.getMovieActors(id)
                _screenState.update { MovieActorScreenState.Success(response) }
            } catch (e : Exception){
                _screenState.update { MovieActorScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}