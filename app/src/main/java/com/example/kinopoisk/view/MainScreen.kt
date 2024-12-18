package com.example.kinopoisk.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kinopoisk.data.BottomNavGraph
import com.example.kinopoisk.data.BottomNavigationItems
import com.example.kinopoisk.model.BottomNavigationBar

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val bottomNavigationItems = listOf(
        BottomNavigationItems.Home,
        BottomNavigationItems.Search,
        BottomNavigationItems.Profile
    )
    Scaffold (
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = bottomNavigationItems,
                onItemClick = {
                    navController.navigate(it.route)
                },
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        )
        {
            BottomNavGraph(navController = navController)
        }
    }
}