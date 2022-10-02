package com.czech.breakingbad.android.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.czech.breakingbad.android.ui.components.CircularProgressBar
import com.czech.breakingbad.android.ui.components.DialogQueue
import com.czech.breakingbad.util.MessageInfo
import com.czech.breakingbad.util.Queue

val LightThemeColors = lightColors(
    primary = Grey900,
    primaryVariant = Grey800,
    onPrimary = Grey700,
    secondary = Grey100,
    secondaryVariant = Grey200,
    onSecondary = Grey200,
    error = Red800,
    onError = Red600,
    background = Grey300,
    onBackground = Grey400,
    surface = Grey400
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
        ) {
            DialogQueue(
                dialogQueue = dialogQueue,
                onRemoveLastMessageFromQueue = onRemoveLastMessageFromQueue
            )
            content()
            CircularProgressBar(
                isDisplayed = displayProgressBar,
                verticalBias = 0.3f)
        }
    }
}