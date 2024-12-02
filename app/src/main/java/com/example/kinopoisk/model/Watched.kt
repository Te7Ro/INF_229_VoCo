package com.example.kinopoisk.model

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.kinopoisk.data.CollectionScreenState
import com.example.kinopoisk.data.CollectionViewModel

@Composable
fun Watched(
    viewModel: CollectionViewModel = viewModel(),
    navHostController: NavHostController
){
    val types = listOf("TOP_POPULAR_ALL")
    val collectionScreenState by viewModel.screenState.collectAsState()
    Column(
        modifier = Modifier.padding(vertical = 24.dp)
    ){
        when(collectionScreenState){
            is CollectionScreenState.Initial -> {
                viewModel.fetchCollections(types)
            }
            is CollectionScreenState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            is CollectionScreenState.Error -> {
                val message = (collectionScreenState as CollectionScreenState.Error).message
                Text(text = message)
            }
            is CollectionScreenState.Success -> {
                val collectionMap = (collectionScreenState as CollectionScreenState.Success).collections
                val collection = collectionMap.getValue("TOP_POPULAR_ALL")

                TitleNum("Просмотрено", collection.total)
                StoryView(collection.items,navHostController)
            }
        }
    }
}