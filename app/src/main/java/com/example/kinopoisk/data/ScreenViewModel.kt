package com.example.kinopoisk.data
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kinopoisk.network.KinopoiskApi

sealed interface ScreenState {
    object Initial : ScreenState
    object Loading : ScreenState
    data class Error(val message: String) : ScreenState
    data class Success(val data: String) : ScreenState
}
class ScreenViewModel : ViewModel() {
    private var screenState: ScreenState by mutableStateOf(ScreenState.Initial)

    init {
        getShtoto()
    }

    fun getShtoto(){
        screenState = ScreenState.Loading
        viewModelScope.launch {
            screenState = try {
                val listResult = KinopoiskApi.retrofitService.getShtoto()
                ScreenState.Success(
                    "Success: you get this $(listresult.size)"
                )
            } catch (e: Exception){
                ScreenState.Error(e.message?: "Unknown error")
            }
        }
    }
}