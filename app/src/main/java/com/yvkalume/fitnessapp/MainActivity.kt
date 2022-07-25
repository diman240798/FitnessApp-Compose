package com.yvkalume.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yvkalume.fitnessapp.presentation.screen.HomeScreen
import com.yvkalume.fitnessapp.presentation.screen.MainScreen
import com.yvkalume.fitnessapp.presentation.screen.WelcomeScreen
import com.yvkalume.fitnessapp.presentation.theme.FitnessappTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main") {
                        composable(route = "main") {
                            MainScreen()
                        }
                        composable(route = "welcome") {
                            WelcomeScreen(navController)
                        }
                        composable(route = "home") {
                            HomeScreen(navController)
                        }
                    }
                }
            }
        }
    }
}