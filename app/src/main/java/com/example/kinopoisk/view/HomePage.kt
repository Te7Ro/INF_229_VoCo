package com.example.kinopoisk.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.kinopoisk.data.FilmViewModel
import com.example.kinopoisk.data.ScreenState
import com.example.kinopoisk.model.Collections

@Composable
fun HomePage(
    viewModel: FilmViewModel = viewModel(),
    navController: NavHostController
){

    val screenState by viewModel.screenState.collectAsState()

    val types = listOf("TOP_POPULAR_ALL", "TOP_POPULAR_MOVIES", "TOP_250_TV_SHOWS")

    Box(modifier = Modifier.fillMaxSize()){
        when (screenState) {
            is ScreenState.Initial -> {
                viewModel.fetchCollections(types)
            }
            is ScreenState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            is ScreenState.Error -> {
                val message = (screenState as ScreenState.Error).message
                Text(text = message)
            }
            is ScreenState.Success -> {
                val collectionMap = (screenState as ScreenState.Success).collections
                Column (modifier = Modifier.padding(start = 26.dp, top = 97.dp)){
                    Text(
                        text = "Skillcinema",
                        fontSize = 30.sp
                    )
                    LazyColumn (modifier = Modifier.padding(top = 65.dp)){
                        items (types) { type ->
                            val collections = collectionMap.getValue(type)
                            Collections(type, collections, navController)
                        }
                    }
                }
            }
        }
    }
}