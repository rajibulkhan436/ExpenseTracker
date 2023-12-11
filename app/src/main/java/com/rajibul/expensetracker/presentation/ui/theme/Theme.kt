package com.rajibul.expensetracker.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.rajibul.expensetracker.util.CompactSpacing
import com.rajibul.expensetracker.util.ExpandedSpacing
import com.rajibul.expensetracker.util.LocalSpacing
import com.rajibul.expensetracker.util.MediumSpacing
import com.rajibul.expensetracker.util.WindowInfo
import com.rajibul.expensetracker.util.rememberWindowInfo

private val DarkColorPalette = darkColors(
    primary = Indigo900,
    secondary = Indigo900,
    background = DeepPurple900,
    surface = DeepPurple300,
    error = Red200,
    onSurface = White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White
)

private val LightColorPalette = lightColors(
    primary = LightBlue500,
    secondary = LightBlue500,
    background = Grey100,
    surface = White,
    error = Red500,
    onSurface = Black,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black
)

@Composable
fun ExpenseTrackerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val windowInfo = rememberWindowInfo()

    CompositionLocalProvider(
        when (windowInfo.screenHeightInfo) {
            is WindowInfo.WindowType.Compact -> {
                LocalSpacing provides CompactSpacing()
            }
            is WindowInfo.WindowType.Medium -> {
                LocalSpacing provides MediumSpacing()
            }
            else -> LocalSpacing provides ExpandedSpacing()
        }
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = Shapes,
            content = content
        )
    }
}