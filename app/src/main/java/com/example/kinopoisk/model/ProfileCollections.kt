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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.kinopoisk.database.ProfileViewModel
import com.example.kinopoisk.di.Resource


@Composable
fun ProfileCollections(
    viewModel: ProfileViewModel = hiltViewModel()
){
    val state by viewModel.likedFilms.collectAsState()

    val cardFav = ProfileCollectionCard(
        title = "Избранное",
        icon = R.drawable.favourite_icon,
        films = emptyList()
    )
    val cardCus = ProfileCollectionCard(
        title = "Русское кино",
        icon = R.drawable.custom_icon,
        films = emptyList()
    )
    val items = mutableListOf(cardFav,cardCus)
    val cardLiked : ProfileCollectionCard

    when(state){
        is Resource.Loading -> {
            CircularProgressIndicator()
        }
        is Resource.Empty -> {
            cardLiked = ProfileCollectionCard(
                title = "Любимые",
                icon = R.drawable.liked_icon,
                films = emptyList()
            )
            items.add(cardLiked)
        }
        is Resource.Success -> {
            cardLiked = ProfileCollectionCard(
                title = "Любимые",
                icon = R.drawable.liked_icon,
                films = (state as Resource.Success).data
            )
            items.add(cardLiked)
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
        CreateNewCollectionButton()
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

){
    Row (
        modifier = Modifier.fillMaxWidth().height(40.dp)
            .clickable {  },
        verticalAlignment = Alignment.CenterVertically
    ){
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