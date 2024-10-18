package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kinopoisk.data.onboardingPagesFromData
import com.example.kinopoisk.ui.theme.Black
import com.example.kinopoisk.ui.theme.Grey

@Composable
fun OnboardingPager() {
    val pagerState = rememberPagerState(0, 0F) { 3 }
    var image = remember { 0 }
    var text = remember { "" }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(state = pagerState) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (page) {
                    0 -> {
                        image = onboardingPagesFromData[0].image
                        text = onboardingPagesFromData[0].desc
                    }

                    1 -> {
                        image = onboardingPagesFromData[1].image
                        text = onboardingPagesFromData[1].desc
                    }

                    2 -> {
                        image = onboardingPagesFromData[2].image
                        text = onboardingPagesFromData[2].desc
                    }
                }

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .padding(bottom = 30.dp),
                    painter = painterResource(id = image),
                    contentDescription = "Image"
                )

                Text(
                    text = text,
                    fontSize = 36.sp
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) Black else Grey
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}
