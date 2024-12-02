package com.example.kinopoisk.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.network.KinopoiskApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface SearchScreenState {
    object Initial : SearchScreenState
    object Loading : SearchScreenState
    data class Error(val message: String) : SearchScreenState
    data class Success(val searchResult: SearchByKeyword) : SearchScreenState
}

class SearchViewModel : ViewModel(){
    private val _screenState = MutableStateFlow<SearchScreenState>(SearchScreenState.Initial)
    val screenState : StateFlow<SearchScreenState> = _screenState

    fun fetchSearch(keyword: String){
        _screenState.update { SearchScreenState.Loading }
        viewModelScope.launch {
            try {
                val response = KinopoiskApi.api.getSearchByKeyword(keyword)
                _screenState.update { SearchScreenState.Success(response) }
            } catch (e : Exception){
                _screenState.update { SearchScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }
}