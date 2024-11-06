package com.example.kinopoisk.view


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.kinopoisk.data.FilmViewModel
import com.example.kinopoisk.data.ScreenState
import com.example.kinopoisk.model.ListPage

@Composable
fun CollectionPage(navController: NavHostController, type: String) {
    val viewModel: FilmViewModel = viewModel()
    val screenState by viewModel.screenState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when (screenState) {
            is ScreenState.Initial -> {
                viewModel.fetchCollections(listOf(type))
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
                val collection = (screenState as ScreenState.Success).collections[type]
                collection?.let {
                    ListPage(navController, it.items, type)
                }
            }
        }
    }
}