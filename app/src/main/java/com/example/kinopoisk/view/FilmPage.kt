package com.example.kinopoisk.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.kinopoisk.data.MovieScreenState
import com.example.kinopoisk.data.MovieViewModel
import com.example.kinopoisk.model.ActorRow
import com.example.kinopoisk.model.FilmDescriptionView
import com.example.kinopoisk.model.FilmHeaderView
import com.example.kinopoisk.model.GaleryView
import com.example.kinopoisk.model.TitleNum
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun FilmPage(
    id: Int,
    navHostController: NavHostController,
    movieViewModel: MovieViewModel = viewModel()
) {

    val screenState by movieViewModel.screenState.collectAsState()
    Box(modifier = Modifier.fillMaxSize()){
        when(screenState){
            is MovieScreenState.Initial -> {
                movieViewModel.fetchMovie(id)
            }
            is MovieScreenState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            is MovieScreenState.Error -> {
                val message = (screenState as MovieScreenState.Error).message
                Text(text = message)
            }
            is MovieScreenState.Success -> {
                val movie = (screenState as MovieScreenState.Success).movieDetailed
                Column {
                    FilmHeaderView(movie)
                    Spacer(modifier = Modifier.height(10.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp)
                    ) {
                        items(1){
                            FilmDescriptionView()
                            TitleNum("Галерея", 27)
                            GaleryView()
                            TitleNum("Актеры",27)
                            ActorRow()

                        }
                    }
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun FilmPagePreview() {
    FilmPage()
}
 */