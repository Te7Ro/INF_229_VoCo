package com.example.kinopoisk.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kinopoisk.data.FilmHeaderViewModel
import com.example.kinopoisk.model.ActorColumn
import com.example.kinopoisk.model.ActorRow
import com.example.kinopoisk.model.FilmDescriptionView
import com.example.kinopoisk.model.FilmHeaderView
import com.example.kinopoisk.model.GaleryView
import com.example.kinopoisk.model.TitleNum

@Composable
fun FilmPage() {
    Column (){
    FilmHeaderView()
    Spacer(modifier = Modifier.height(10.dp))
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)
    ) {
       items(1){
           FilmDescriptionView()
           TitleNum("Galery")
           GaleryView()
           TitleNum("Гей порнография")
           ActorRow()
       }
    }
}}


@Preview(showBackground = true)
@Composable
fun FilmPagePreview() {
    FilmPage()
}