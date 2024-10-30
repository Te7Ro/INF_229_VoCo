package com.example.kinopoisk.model

import androidx.compose.runtime.Composable
import com.example.kinopoisk.data.ScreenState

@Composable
fun ScreenStateUi(screenState: ScreenState){
    when (screenState){
        is ScreenState.Initial -> InitialScreen()
        is ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen()
        is ScreenState.Success -> SuccessScreen()
    }
}

@Composable
fun InitialScreen(){

}

@Composable
fun LoadingScreen(){

}

@Composable
fun ErrorScreen(){

}

@Composable
fun SuccessScreen(){

}