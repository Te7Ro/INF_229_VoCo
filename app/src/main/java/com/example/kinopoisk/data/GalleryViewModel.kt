package com.example.kinopoisk.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface GalleryScreenState {
    object Initial : GalleryScreenState
    object Loading : GalleryScreenState
    data class Error(val message: String) : GalleryScreenState
    data class Success(val gallery: Map<String, Gallery>) : GalleryScreenState
}

class GalleryViewModel : ViewModel(){
    private val _screenState = MutableStateFlow<GalleryScreenState>(GalleryScreenState.Initial)
    val screenState : StateFlow<GalleryScreenState> = _screenState

    private val galleryMap = mutableMapOf<String, Gallery>()

    fun fetchGallery(id: Int, types: List<String>){
        _screenState.update { GalleryScreenState.Loading }
        viewModelScope.launch {
            try {
                for(type in types){
                    val response = KinopoiskApi.api.getGallery(id,type)
                    galleryMap[type] = response
                }
                _screenState.update { GalleryScreenState.Success(galleryMap) }
            } catch (e : Exception){
                _screenState.update { GalleryScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}