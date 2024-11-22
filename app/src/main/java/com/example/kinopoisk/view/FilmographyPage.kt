package com.example.kinopoisk.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.kinopoisk.data.ActorMovieScreenState
import com.example.kinopoisk.data.ActorMovieViewModel
import com.example.kinopoisk.model.FilmographyDetail

@Composable
fun FilmographyPage(
    navController: NavHostController,
    actorId: Int,
    actorMovieViewModel: ActorMovieViewModel = viewModel()
) {
    val actorMovieState by actorMovieViewModel.screenState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when (actorMovieState) {
            is ActorMovieScreenState.Initial -> {
                LaunchedEffect(Unit) {
                    actorMovieViewModel.fetchActorAndFilms(actorId)
                }
            }

            is ActorMovieScreenState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            is ActorMovieScreenState.Error -> {
                val message = (actorMovieState as ActorMovieScreenState.Error).message
                Text(text = message, modifier = Modifier.align(Alignment.Center))
            }

            is ActorMovieScreenState.Success -> {
                val actor = (actorMovieState as ActorMovieScreenState.Success).actor
                val films = (actorMovieState as ActorMovieScreenState.Success).films

                FilmographyDetail(
                    films = films,
                    navController = navController,
                    actor = actor
                )
            }
        }
    }
}

