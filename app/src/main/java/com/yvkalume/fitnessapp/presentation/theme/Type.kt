package com.yvkalume.fitnessapp.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
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
        color = Color.Black,
        fontSize = 18.sp
    ),

    caption = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Normal,
        color = Gray700,
        fontSize = 14.sp
    ),

    h1 = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        fontSize = 28.sp
    ),

    h2 = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        fontSize = 24.sp
    ),

    h3 = TextStyle(
        fontFamily = myFontFamily,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        fontSize = 18.sp
    )
)