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
import com.example.kinopoisk.data.CollectionViewModel
import com.example.kinopoisk.data.CollectionScreenState
import com.example.kinopoisk.model.ListPage

@Composable
fun CollectionPage(navController: NavHostController, type: String) {
    val viewModel: CollectionViewModel = viewModel()
    val screenState by viewModel.screenState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when (screenState) {
            is CollectionScreenState.Initial -> {
                viewModel.fetchCollections(listOf(type))
            }

            is CollectionScreenState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is CollectionScreenState.Error -> {
                val message = (screenState as CollectionScreenState.Error).message
                Text(text = message)
            }

            is CollectionScreenState.Success -> {
                val collection = (screenState as CollectionScreenState.Success).collections[type]
                collection?.let {
                    ListPage(navController, it.items, type)
                }
            }
        }
    }
}