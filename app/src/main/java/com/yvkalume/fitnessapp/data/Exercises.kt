package com.yvkalume.fitnessapp.data

import com.yvkalume.fitnessapp.R

enum class Exercises(val nameRes: Int, val imageRes: Int, val exercisesList: Int) {
    HANDS(R.string.exercises_hands, R.drawable.ic_exercises_hands, R.array.subsection_arr_1),
    SHOULDERS(R.string.exercises_shoulders, R.drawable.ic_exercises_shoulders, R.array.subsection_arr_2),
    CHEST(R.string.exercises_chest, R.drawable.ic_exercises_chest, R.array.subsection_arr_3),
    BACK(R.string.exercises_back, R.drawable.ic_exercises_back, R.array.subsection_arr_4),
    LEGS(R.string.exercises_legs, R.drawable.ic_exercises_legs, R.array.subsection_arr_5),
    GLUTES(R.string.exercises_glutes, R.drawable.ic_exercises_glutes, R.array.subsection_arr_6),
    ABS(R.string.exercises_abs, R.drawable.ic_exercises_abs, R.array.subsection_arr_7),
}
