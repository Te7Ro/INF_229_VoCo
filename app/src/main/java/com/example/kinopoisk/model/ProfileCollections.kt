package com.example.kinopoisk.model

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileCollections(){
    Column(
        modifier = Modifier.fillMaxWidth().height(400.dp).padding(vertical = 16.dp)
    ){
        Text(
            text = "Коллекции",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        CreateNewCollectionButton()

    }
}


@Composable
fun CreateNewCollectionButton(){
    Row (
        modifier = Modifier.fillMaxWidth().height(40.dp)
            .clickable {  },
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = "+", fontSize = 24.sp)
        Spacer(Modifier.width(11.dp))
        Text(text = "Создать свою коллекцию", fontSize = 18.sp)
    }
}