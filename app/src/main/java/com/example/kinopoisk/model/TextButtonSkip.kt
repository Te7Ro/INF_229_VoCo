package com.example.kinopoisk.model

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kinopoisk.ui.theme.Grey

@Composable
fun TextButtonSkip(text : String, onClick : () -> Unit){
    var enabled by rememberSaveable{ mutableStateOf(true)}
    Text(
        modifier = Modifier
            .clickable(enabled = enabled) {
                enabled = true
                onClick()
            },
        text = text,
        fontSize = 16.sp,
        color = Grey,
        fontWeight = FontWeight.Light
    )
}