package com.ibrajix.c2c.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Colors.greyBg : Color get() = bgGrey

private val DarkColorPalette = darkColors(
    primary = black,
    primaryVariant = black,
    secondary = mainYellow,
    surface = black,
    onPrimary = white,
    onSurface = white
)

private val LightColorPalette = lightColors(
    primary = white,
    primaryVariant = white,
    secondary = mainYellow,
    surface = white,
    onPrimary = black,
    onSurface = black
)

@Composable
fun C2CTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = MyTypography,
        shapes = Shapes,
        content = content
    )
}