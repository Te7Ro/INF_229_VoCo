package com.example.kinopoisk.data

import com.example.kinopoisk.R


sealed class BottomNavigationItems (
    val route: String,
    val icon: Int,
){
    data object Home : BottomNavigationItems(
        route = "home",
        icon = R.drawable.home_icon
    )
    data object Search : BottomNavigationItems(
        route = "search",
        icon = R.drawable.search_icon
    )
    data object Profile : BottomNavigationItems(
        route = "profile",
        icon = R.drawable.profile_icon
    )
}