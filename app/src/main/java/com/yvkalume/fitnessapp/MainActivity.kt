package com.yvkalume.fitnessapp

import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.content.ContextCompat
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
        setTheme(R.style.Fitnessapp)
        super.onCreate(savedInstanceState)
        setStatusBarGradiant(this)
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

    fun setStatusBarGradiant(activity: Activity) {
        val window: Window = activity.window
        val background = ContextCompat.getDrawable(activity, R.drawable.gradient)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        window.statusBarColor = ContextCompat.getColor(activity, android.R.color.transparent)
        window.navigationBarColor = ContextCompat.getColor(activity, android.R.color.transparent)
        window.setBackgroundDrawable(background)
    }
}