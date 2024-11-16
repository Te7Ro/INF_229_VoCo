package com.example.kinopoisk.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface SimilarScreenState {
    object Initial : SimilarScreenState
    object Loading : SimilarScreenState
    data class Error(val message: String) : SimilarScreenState
    data class Success(val similar: Similar) : SimilarScreenState
}

class SimilarViewModel : ViewModel(){
    private val _screenState = MutableStateFlow<SimilarScreenState>(SimilarScreenState.Initial)
    val screenState : StateFlow<SimilarScreenState> = _screenState

    fun fetchSimilars(id: Int){
        _screenState.update { SimilarScreenState.Loading }
        viewModelScope.launch {
            try {
                val response = KinopoiskApi.api.getSimilars(id)
                _screenState.update { SimilarScreenState.Success(response) }
            } catch (e : Exception){
                _screenState.update { SimilarScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}