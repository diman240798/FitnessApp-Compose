package com.yvkalume.fitnessapp

import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.unit.IntOffset
import androidx.core.content.ContextCompat
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yvkalume.fitnessapp.presentation.screen.exerciselist.ExercisesListScreen
import com.yvkalume.fitnessapp.presentation.screen.main.MainScreen
import com.yvkalume.fitnessapp.presentation.theme.FitnessappTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Fitnessapp)
        super.onCreate(savedInstanceState)
        setStatusBarGradiant(this)
        setContent {
            FitnessappTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(navController = navController, startDestination = "main") {
                        composable(route = "main") {
                            MainScreen(navController)
                        }
                        composable(
                            route = "exercises_list",
                            enterTransition = { _, _ ->
                                slideIn({ IntOffset(0, it.height / 2) }, tween(800))
                            },
                            exitTransition = { _, _ ->
                                slideOut({ IntOffset(0, it.height / 2) }, tween(800))
                            }
                        ) {
                            ExercisesListScreen()
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