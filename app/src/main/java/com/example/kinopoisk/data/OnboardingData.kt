package com.example.kinopoisk.data

import com.example.kinopoisk.R


data class OnboardingData(
    val image: Int,
    val desc: String
)

val onboardingPagesFromData = listOf<OnboardingData>(
    OnboardingData(
        R.drawable.onboarding1,
        "Узнавай о премьерах"
    ),
    OnboardingData(
        R.drawable.onboarding2,
        "Создавай коллекции"
    ),
    OnboardingData(
        R.drawable.onboarding3,
        "Делись с друзьями"
    )
)

