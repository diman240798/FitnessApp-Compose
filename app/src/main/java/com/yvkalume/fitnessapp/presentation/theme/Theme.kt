package com.yvkalume.fitnessapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = Black700,
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = Gray700
)

private val LightColorPalette = lightColors(
    background = Black700,
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = Gray700
)

@Composable
fun FitnessappTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}