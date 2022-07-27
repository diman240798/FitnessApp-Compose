package com.yvkalume.fitnessapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

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


@Preview
@Composable
@ExperimentalPagerApi
fun MainScreenPreview() {
    MainScreen()
}
