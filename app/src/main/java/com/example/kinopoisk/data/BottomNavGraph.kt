package com.example.kinopoisk.data

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kinopoisk.R
import com.example.kinopoisk.view.HomePage
import com.example.kinopoisk.view.Profile
import com.example.kinopoisk.view.Search

sealed class BottomNavigationItems (
    val route: String,
    val icon: Int,
){
    object Home : BottomNavigationItems(
        route = "home",
        icon = R.drawable.home_icon
    )
    object Search : BottomNavigationItems(
        route = "search",
        icon = R.drawable.search_icon
    )
    object Profile : BottomNavigationItems(
        route = "profile",
        icon = R.drawable.profile_icon
    )
}

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItems.Home.route
    ){
        composable(BottomNavigationItems.Home.route){
            HomePage()
        }
        composable(BottomNavigationItems.Search.route){
            Search()
        }
        composable(BottomNavigationItems.Profile.route){
            Profile()
        }
    }
}
