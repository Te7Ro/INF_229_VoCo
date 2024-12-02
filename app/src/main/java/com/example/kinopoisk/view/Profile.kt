package com.example.kinopoisk.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kinopoisk.model.TitleNum
import com.example.kinopoisk.model.Watched

@Composable
fun Profile(
    navHostController: NavHostController
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 26.dp, top = 56.dp)
    ){
        Watched(navHostController = navHostController)
    }
}