package com.example.kinopoisk.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kinopoisk.Modeli.SpisokView
import com.example.kinopoisk.Modeli.TitleAll
import com.example.kinopoisk.data.Data

@Preview(showBackground = true)
@Composable
fun HomePage(){
    Box(modifier = Modifier.fillMaxSize()){
        Column (modifier = Modifier.padding(start = 26.dp, top = 97.dp)){
            Text(
                text = "Skillcinema",
                fontSize = 30.sp
            )
            LazyColumn (modifier = Modifier.padding(top = 65.dp)){
                items(Data.list){ item ->
                    TitleAll(item.Title)
                    LazyRow(modifier = Modifier.padding(bottom = 20.dp)){
                        items(item.Items){
                            SpisokView(it)
                        }
                    }
                }
            }
        }
    }
}
