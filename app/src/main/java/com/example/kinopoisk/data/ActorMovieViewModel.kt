package com.example.kinopoisk.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface ActorMovieScreenState {
    object Initial : ActorMovieScreenState
    object Loading : ActorMovieScreenState
    data class Error(val message: String) : ActorMovieScreenState
    data class Success(
        val actor: ActorDetailed,
        val films: List<MovieDetailed>
    ) : ActorMovieScreenState
}

class ActorMovieViewModel : ViewModel() {
    private val _screenState = MutableStateFlow<ActorMovieScreenState>(ActorMovieScreenState.Initial)
    val screenState: StateFlow<ActorMovieScreenState> = _screenState

    fun fetchActorAndFilms(id: Int) {
        _screenState.update { ActorMovieScreenState.Loading }
        viewModelScope.launch {
            try {
                val actor = KinopoiskApi.api.getActor(id)

                val films = actor.films.mapNotNull { film ->
                    try {
                        KinopoiskApi.api.getMovie(film.filmId)
                    } catch (e: Exception) {
                        Log.e("ActorMovieViewModel", "Failed to fetch movie with id: ${film.filmId}", e)
                        null
                    }
                }

                _screenState.update { ActorMovieScreenState.Success(actor, films) }
            } catch (e: Exception) {
                _screenState.update { ActorMovieScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}
