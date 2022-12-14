package com.yvkalume.fitnessapp.presentation.screen.main

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.yvkalume.fitnessapp.presentation.screen.ExercisesScreen
import com.yvkalume.fitnessapp.presentation.screen.main.menprogram.MenProgramsScreen
import com.yvkalume.fitnessapp.presentation.screen.main.womenprogram.WomenProgramsScreen
import com.yvkalume.fitnessapp.presentation.theme.White

@Composable
@ExperimentalPagerApi
fun MainScreen(navController: NavHostController) {
    HorizontalPager(count = 3, modifier = Modifier.background(White)) { page ->
        when (page) {
            0 -> ExercisesScreen(navController)
            1 -> MenProgramsScreen(navController)
            else -> WomenProgramsScreen(navController)
        }
    }
}


@Preview
@Composable
@ExperimentalPagerApi
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController)
}
