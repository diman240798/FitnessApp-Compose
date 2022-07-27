package com.yvkalume.fitnessapp.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.yvkalume.fitnessapp.R

val myFontFamily = FontFamily(
    Font(R.font.commissioner_regular, FontWeight.Normal),
    Font(R.font.commissioner_medium, FontWeight.Medium),
    Font(R.font.commissioner_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(

    body1 = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    h2 = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    )


)