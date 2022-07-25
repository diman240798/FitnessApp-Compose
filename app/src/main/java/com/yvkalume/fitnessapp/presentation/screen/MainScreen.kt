package com.yvkalume.fitnessapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.yvkalume.fitnessapp.R

@Composable
@ExperimentalPagerApi
fun MainScreen() {
    HorizontalPager(count = 3, modifier = Modifier.background(Color.White)) { page ->
        when (page) {
            0 -> ExercisesScreen()
            1 -> MenProgramsScreen()
            else -> WomenProgramsScreen()
        }
    }
}

@Composable
fun ExercisesScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_exercises_slice),
            contentDescription = "Android",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun MenProgramsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_men_programs_slice),
            contentDescription = "Android",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun WomenProgramsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_women_programs_slice),
            contentDescription = "Android",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
    }
}


@Preview
@Composable
@ExperimentalPagerApi
fun MainScreenPreview() {
    MainScreen()
}