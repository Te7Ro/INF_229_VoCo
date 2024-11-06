package com.example.kinopoisk.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.kinopoisk.model.ListPage

@Composable
fun CollectionPage(navController: NavHostController){
    ListPage(navController)
}