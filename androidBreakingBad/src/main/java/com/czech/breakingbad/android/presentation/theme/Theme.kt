package com.czech.breakingbad.android.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.czech.breakingbad.util.MessageInfo
import com.czech.breakingbad.util.Queue

val LightThemeColors = lightColors(
    primary = Grey900,
    primaryVariant = Grey800,
    onPrimary = Grey700,
    secondary = Grey100,
    secondaryVariant = Grey200,
    onSecondary = Grey300,
    error = Red800,
    onError = Red600,
    background = Grey600,
    onBackground = Grey400,
    surface = Teal200
)

@Composable
fun AppTheme(
    displayProgressBar: Boolean,
    dialogQueue: Queue<MessageInfo> = Queue(mutableListOf()),
    onRemoveLastMessageFromQueue: () -> Unit,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightThemeColors,
        typography = RobotoTypography,
        shapes = AppShapes,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Grey600)
        ) {

        }
    }
}