package com.example.kinopoisk.data
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

sealed interface ScreenState {
    object Initial : ScreenState
    object Loading : ScreenState
    data class Error(val message: String) : ScreenState
    data class Success(val collections: Collection) : ScreenState
}
class FilmViewModel : ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Initial)
    val screenState : StateFlow<ScreenState> = _screenState

    fun fetchCollections(type: String) {
        _screenState.update { ScreenState.Loading }
        viewModelScope.launch {
            try {
                val response = KinopoiskApi.api.getCollection(type)
                _screenState.update { ScreenState.Success(response) }
            } catch (e: Exception) {
                _screenState.update { ScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}
