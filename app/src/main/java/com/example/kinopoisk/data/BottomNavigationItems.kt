package com.example.kinopoisk.data

import com.example.kinopoisk.R


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