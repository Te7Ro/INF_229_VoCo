package com.example.kinopoisk.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kinopoisk.data.FilmViewModel
import com.example.kinopoisk.data.ScreenState
import com.example.kinopoisk.model.Collections
import com.example.kinopoisk.model.SpisokView
import com.example.kinopoisk.model.TitleAll

@Preview(showBackground = true)
@Composable
fun HomePage(viewModel: FilmViewModel = viewModel()){

    val screenState by viewModel.screenState.collectAsState()

    val types = listOf("TOP_POPULAR_ALL", "FAMILY", "ZOMBIE_THEME")

    Box(modifier = Modifier.fillMaxSize()){
        when (screenState) {
            is ScreenState.Initial -> {
                for(type in types)
                {
                    viewModel.fetchCollections(type)
                }
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
                Column (modifier = Modifier.padding(start = 26.dp, top = 97.dp)){
                    Text(
                        text = "Skillcinema",
                        fontSize = 30.sp
                    )
                    LazyColumn (modifier = Modifier.padding(top = 65.dp)){
                        item {
                            val collections = (screenState as ScreenState.Success).collections
                            Collections("TOP_POPULAR_ALL", collections)
                        }
                    }
                }
            }
        }
    }
}