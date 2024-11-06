package com.example.kinopoisk.data
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import com.example.kinopoisk.data.Collection

sealed interface ScreenState {
    object Initial : ScreenState
    object Loading : ScreenState
    data class Error(val message: String) : ScreenState
    data class Success(val collections: Map<String, Collection>) : ScreenState
}
class FilmViewModel : ViewModel() {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Initial)
    val screenState : StateFlow<ScreenState> = _screenState

    private val collectionMap = mutableMapOf<String, Collection>()

    fun fetchCollections(types: List<String>) {
        _screenState.update { ScreenState.Loading }
        viewModelScope.launch {
            try {
                for(type in types){
                    val response = KinopoiskApi.api.getCollection(type)
                    collectionMap[type] = response
                }

                _screenState.update { ScreenState.Success(collectionMap) }
            } catch (e: Exception) {
                _screenState.update { ScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}
