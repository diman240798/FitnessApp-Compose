package com.yvkalume.fitnessapp.data

import com.yvkalume.fitnessapp.R

enum class Exercises(val nameRes: Int, val imageRes: Int) {
    HANDS(R.string.exercises_hands, R.drawable.ic_exercises_hands),
    SHOULDERS(R.string.exercises_shoulders, R.drawable.ic_exercises_shoulders),
    CHEST(R.string.exercises_chest, R.drawable.ic_exercises_chest),
    BACK(R.string.exercises_back, R.drawable.ic_exercises_back),
    LEGS(R.string.exercises_legs, R.drawable.ic_exercises_legs),
    GLUTES(R.string.exercises_glutes, R.drawable.ic_exercises_glutes),
    ABS(R.string.exercises_abs, R.drawable.ic_exercises_abs),
}

enum class HandsExercises