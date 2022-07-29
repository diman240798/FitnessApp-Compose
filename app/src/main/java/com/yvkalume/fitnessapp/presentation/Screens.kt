package com.yvkalume.fitnessapp.presentation

import com.yvkalume.fitnessapp.data.Exercises

sealed class Screens(val route: String) {

    object Main : Screens("main")

    object ExercicesList : Screens("exercise_list/{type}") {
        fun createRoute(type: Exercises) = "exercise_list/${type}"
    }

    object WebView : Screens("webview?url={url}") {
        fun createRoute(url: String) = "webview?url=${url}"
    }
}
