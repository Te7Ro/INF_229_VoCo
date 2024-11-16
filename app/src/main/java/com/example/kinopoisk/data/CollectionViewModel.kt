package com.example.kinopoisk.data
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

sealed interface CollectionScreenState {
    object Initial : CollectionScreenState
    object Loading : CollectionScreenState
    data class Error(val message: String) : CollectionScreenState
    data class Success(val collections: Map<String, Collection>) : CollectionScreenState
}

class CollectionViewModel : ViewModel() {
    private val _screenState = MutableStateFlow<CollectionScreenState>(CollectionScreenState.Initial)
    val screenState : StateFlow<CollectionScreenState> = _screenState

    private val collectionMap = mutableMapOf<String, Collection>()

    fun fetchCollections(types: List<String>) {
        _screenState.update { CollectionScreenState.Loading }
        viewModelScope.launch {
            try {
                for(type in types){
                    val response = KinopoiskApi.api.getCollection(type)
                    collectionMap[type] = response
                }

                _screenState.update { CollectionScreenState.Success(collectionMap) }
            } catch (e: Exception) {
                _screenState.update { CollectionScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}
