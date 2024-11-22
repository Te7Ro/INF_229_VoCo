package com.example.kinopoisk.model

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kinopoisk.R
import com.example.kinopoisk.data.FilmHeaderViewModel

@Composable
fun FilmHeaderView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp)
            .background(Color.Gray)
            .height(400.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        // Film Title
        Text(
            text = "Kitoboy",
            color = Color.White
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Film Rating and Details
        Text(
            text = "6.4, Kitoboy",
            color = Color.White
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "2020, drama, pirkoli",
            color = Color.White
        )

        Text(
            text = "Russia, dohuya, 16+",
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //for images
        }
    }
}