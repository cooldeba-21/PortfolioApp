package com.debashis.portfolio.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = TechyBlueDarkPrimary,
    primaryVariant = TechyBlueDarkPrimaryVariant,
    secondary = TechyBlueDarkSecondary,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = OnPrimary,
    onSecondary = OnSecondary
)

private val LightColorPalette = lightColors(
    primary = TechyBluePrimary,
    primaryVariant = TechyBluePrimaryVariant,
    secondary = TechyBlueSecondary,
    background = BackgroundLight,
    surface = SurfaceLight,
    onPrimary = OnPrimary,
    onSecondary = OnSecondary
)

@Composable
fun PortfolioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}
