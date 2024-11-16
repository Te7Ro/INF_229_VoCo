package com.example.kinopoisk.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface ActorScreenState {
    object Initial : ActorScreenState
    object Loading : ActorScreenState
    data class Error(val message: String) : ActorScreenState
    data class Success(val actor: ActorDetailed) : ActorScreenState
}

class ActorViewModel : ViewModel(){
    private val _screenState = MutableStateFlow<ActorScreenState>(ActorScreenState.Initial)
    val screenState : StateFlow<ActorScreenState> = _screenState

    fun fetchActor(id: Int){
        _screenState.update { ActorScreenState.Loading }
        viewModelScope.launch {
            try {
                val response = KinopoiskApi.api.getActor(id)
                _screenState.update { ActorScreenState.Success(response) }
            } catch (e : Exception){
                _screenState.update { ActorScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}