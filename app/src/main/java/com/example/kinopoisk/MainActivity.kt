package com.example.kinopoisk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.kinopoisk.data.MainNavGraph
import com.example.kinopoisk.ui.theme.KinopoiskTheme
import com.example.kinopoisk.view.ActorPage
import com.example.kinopoisk.view.FilmographyPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KinopoiskTheme {
                val navController = rememberNavController()
                MainNavGraph(navController)
            }
        }
    }
}