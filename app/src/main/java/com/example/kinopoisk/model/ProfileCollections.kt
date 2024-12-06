package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kinopoisk.data.ProfileCollectionCard
import com.example.kinopoisk.R
import com.example.kinopoisk.database.ProfileFilm
import com.example.kinopoisk.database.ProfileViewModel
import com.example.kinopoisk.di.Resource


@Composable
fun ProfileCollections(
    viewModel: ProfileViewModel = hiltViewModel()
){
    val state by viewModel.collections.collectAsState()
    val map = mutableMapOf<String, MutableList<Int>>()

    val items = mutableListOf<ProfileCollectionCard>()

    when(state){
        is Resource.Loading -> {
            CircularProgressIndicator()
        }
        is Resource.Empty -> {
            val cardLiked = ProfileCollectionCard(
                title = "Любимые",
                icon = R.drawable.liked_icon,
                films = emptyList()
            )
            val cardFav = ProfileCollectionCard(
                title = "Избранное",
                icon = R.drawable.favourite_icon,
                films = emptyList()
            )
            items.add(cardLiked)
            items.add(cardFav)
        }
        is Resource.Success -> {
            val listOfCollection = (state as Resource.Success).data

            for(films in listOfCollection){
                map[films.category] = mutableListOf()
                val list : MutableList<Int> = map.getValue(films.category)
                list.add(films.movieId)
                map[films.category] = list
            }

            for (mp in map){
                val icon : Int
                if(mp.key == "Любимые")icon = R.drawable.liked_icon
                else if (mp.key == "Избранное")icon = R.drawable.favourite_icon
                else icon = R.drawable.custom_icon
                val card = ProfileCollectionCard(
                    title = mp.key,
                    icon = icon,
                    films = mp.value
                )
                items.add(card)
            }
        }
        else -> {}
    }

    Column(
        modifier = Modifier.fillMaxWidth().height(400.dp)
    ){
        Text(
            text = "Коллекции",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        CreateNewCollectionButton(viewModel)
        Spacer(Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            items(items){ item ->
                CollectionCard(item)
            }

        }

    }
}


@Composable
fun CreateNewCollectionButton(
    viewModel: ProfileViewModel
){
    var showDialog by remember { mutableStateOf(false) }
    Row (
        modifier = Modifier.fillMaxWidth().height(40.dp)
            .clickable { showDialog = true },
        verticalAlignment = Alignment.CenterVertically
    ){
        if(showDialog){
            ShowAlertDialog(
                onDismiss = {showDialog = false},
                onConfirm = { gettedCollectionName, gettedMovieId ->
                    showDialog = false
                    val profileFilm = ProfileFilm(
                        movieId = gettedMovieId.toInt(),
                        category = gettedCollectionName
                    )
                    viewModel.insertFilm(profileFilm)

                }
            )
        }
        Text(
            text = "+", fontSize = 24.sp
        )
        Spacer(Modifier.width(11.dp))
        Text(
            text = "Создай свою коллекцию",
            fontSize = 18.sp
        )
    }
}

@Composable
fun ShowAlertDialog(
    onDismiss: () -> Unit,
    onConfirm: (String, String) -> Unit
){
    var collectionName by remember { mutableStateOf("") }
    var movieId by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = {onDismiss()},
        title = {
            Text(text = "Enter Details")
        },
        text = {
            Column {
                TextField(
                    value = collectionName,
                    onValueChange = { collectionName = it },
                    label = { Text("Write Collection Name") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = movieId,
                    onValueChange = { movieId = it },
                    label = { Text("Movie Id") },
                    singleLine = true
                )
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(collectionName, movieId) }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}


@Composable
fun CollectionCard(card : ProfileCollectionCard){
    Box (
        modifier = Modifier.size(152.dp)
            .padding(bottom = 16.dp, end = 16.dp)
            .border(2.dp, MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp)),
    ){
        Column (
            modifier = Modifier.fillMaxSize().padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Image(painter = painterResource(card.icon), contentDescription = null)
            Text(text = card.title, fontSize = 16.sp)
            Text(text = card.films.size.toString(),
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 4.dp, vertical = 2.dp),
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}