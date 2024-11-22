package com.example.kinopoisk.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kinopoisk.model.GalleryTitle
import com.example.kinopoisk.model.photos

@Composable
fun Gallery(){
    LazyColumn(Modifier.fillMaxWidth()) {
        item {
            GalleryTitle()
            photos()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GalleryPreview() {
    Gallery()
}