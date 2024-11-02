package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kinopoisk.data.ScreenState
import com.example.kinopoisk.R
import com.example.kinopoisk.ui.theme.KinopoiskTheme

@Composable
fun ScreenStateUi(screenState: ScreenState){
    when (screenState){
        is ScreenState.Initial -> InitialScreen()
        is ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> {
            val message = (screenState as ScreenState.Error).message
            ErrorScreen(message)
        }
        is ScreenState.Success -> SuccessScreen()
    }
}

@Composable
fun InitialScreen(){

}

@Composable
fun LoadingScreen(){
    Image(
        modifier = Modifier.size(200.dp),
        painter = painterResource(R.drawable.loading),
        contentDescription = ""
    )
}

@Composable
fun ErrorScreen(message: String?){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.error),
            contentDescription = ""
        )
        Text(text = message.toString())
    }
}

@Composable
fun SuccessScreen(){

}