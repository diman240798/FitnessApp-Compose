package com.yvkalume.fitnessapp

import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.content.ContextCompat
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yvkalume.fitnessapp.data.Exercises
import com.yvkalume.fitnessapp.presentation.Screens
import com.yvkalume.fitnessapp.presentation.screen.exerciselist.ExercisesListScreen
import com.yvkalume.fitnessapp.presentation.screen.main.MainScreen
import com.yvkalume.fitnessapp.presentation.screen.webview.WebViewScreen
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
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screens.Main.route
                    ) {

                        composable(route = Screens.Main.route) {
                            MainScreen(navController)
                        }

                        composable(
                            route = Screens.ExercicesList.route,
                            enterTransition = {
                                slideIntoContainer(
                                    AnimatedContentScope.SlideDirection.Up,
                                    animationSpec = tween(800),
                                    initialOffset = { it / 2 }
                                )
                            },
                            exitTransition = {
                                slideOutOfContainer(
                                    AnimatedContentScope.SlideDirection.Down,
                                    animationSpec = tween(800),
                                    targetOffset = { it / 2 }
                                )
                            },
                            arguments = listOf(
                                navArgument("type") {
                                    type = NavType.EnumType(Exercises::class.java)
                                }
                            )
                        ) {
                            val type = it.arguments!!.get("type") as Exercises
                            ExercisesListScreen(navController, type)
                        }

                        composable(
                            route = Screens.WebView.route,
                            arguments = listOf(
                                navArgument("url") { type = NavType.StringType }
                            )
                        ) {
                            WebViewScreen(url = it.arguments!!.getString("url")!!)
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