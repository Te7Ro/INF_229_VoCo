package com.example.kinopoisk.data

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.kinopoisk.view.OnboardingScreen
import com.example.kinopoisk.view.MainScreen

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

@Composable
fun MainNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = MainNavigationItems.onBoarding.route
    ){
        composable(MainNavigationItems.onBoarding.route){
            OnboardingScreen(navController)
        }
        composable(MainNavigationItems.MainScreen.route){
            MainScreen()
        }
    }
}