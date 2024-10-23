package com.example.kinopoisk.data

sealed class MainNavigationItems(
    val route: String
) {
    object onBoarding : MainNavigationItems(
        route = "OnBoarding"
    )
    object MainScreen : MainNavigationItems(
        route = "MainScreen"
    )
}
