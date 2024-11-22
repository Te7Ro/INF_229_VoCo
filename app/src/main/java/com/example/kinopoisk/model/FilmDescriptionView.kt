package com.example.kinopoisk.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilmDescriptionView() {
    Column(modifier = Modifier) {
        Text(
            text = "Чукотский парень влюбляется " +
                    "в американскую вебкам-модель. Приз Венеции, Кристина Асмус " +
                    "в роли девушки мечты",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Все меняется в жизни юного чукотского охотника Лёшки " +
                    "с появлением в поселке интернета. Он влюбляется — впервые и сильно — " +
                    "в молчаливую девушку...",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}