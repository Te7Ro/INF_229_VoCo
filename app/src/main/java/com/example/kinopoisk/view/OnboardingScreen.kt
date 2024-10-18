@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kinopoisk.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kinopoisk.model.OnboardingPager
import com.example.kinopoisk.model.TextButtonSkip

@Composable
fun OnboardingScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize().padding(26.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Skillcinema",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Light
                    )
                },
                actions = {
                    TextButtonSkip("Пропустить", onClick = {})
                }
            )
        }
    ){ paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            OnboardingPager()
        }
    }
}