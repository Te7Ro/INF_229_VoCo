package com.example.kinopoisk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.kinopoisk.data.MainNavGraph
import com.example.kinopoisk.ui.theme.KinopoiskTheme
import com.example.kinopoisk.view.FilmPage
import com.example.kinopoisk.view.Gallery

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KinopoiskTheme {
                Gallery()
            }
        }
    }
}