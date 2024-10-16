package com.example.kinopoisk.Modeli

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleAll(Title: String){
    Row (modifier = Modifier.fillMaxWidth()
        .padding(vertical = 12.dp)
        .padding(end = 26.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        )
    {
        Text(
            text = Title,
            fontSize = 18.sp,
            style = TextStyle(
                fontWeight = FontWeight.Bold
        )

        )
        Text(
            text = "Все",
            fontSize = 14.sp,
            color = Color(0xFF3D3BFF)
            )
    }
}