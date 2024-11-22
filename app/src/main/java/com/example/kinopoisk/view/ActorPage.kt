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
import com.example.kinopoisk.data.ActorScreenState
import com.example.kinopoisk.data.ActorViewModel
import com.example.kinopoisk.model.ActorDetail

@Composable
fun ActorPage(navController: NavHostController, actorId: Int) {
    val viewModel: ActorViewModel = viewModel()
    val screenState by viewModel.screenState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when (screenState) {
            is ActorScreenState.Initial -> {
                viewModel.fetchActor(actorId)
            }

            is ActorScreenState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            is ActorScreenState.Error -> {
                val message = (screenState as ActorScreenState.Error).message
                Text(text = message)
            }

            is ActorScreenState.Success -> {
                val actor = (screenState as ActorScreenState.Success).actor
                ActorDetail(actor, navController)
            }
        }
    }
}