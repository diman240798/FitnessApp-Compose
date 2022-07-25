package com.yvkalume.fitnessapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@Composable
@ExperimentalPagerApi
fun MainScreen() {
    HorizontalPager(count = 3) { page ->
        when(page) {
            1 -> ExercisesScreen()
            2 -> MenProgramsScreen()
            else -> WomenProgramsScreen()
        }
    }
}

@Composable
fun ExercisesScreen() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue))
}

@Composable
fun MenProgramsScreen() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Green))
}

@Composable
fun WomenProgramsScreen() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Yellow))
}


@Preview
@Composable
@ExperimentalPagerApi
fun MainScreenPreview() {
    MainScreen()
}