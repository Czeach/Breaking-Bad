package com.czech.breakingbad.android.presentation.components

import androidx.compose.runtime.Composable
import com.czech.breakingbad.util.MessageInfo
import com.czech.breakingbad.util.Queue

@Composable
fun DialogQueue(
    dialogQueue: Queue<MessageInfo>?,
    onRemoveLastMessageFromQueue: () -> Unit
) {
    dialogQueue?.peek()?.let { dialogInfo ->
        Dialog(
            onDismiss = dialogInfo.onDismiss,
            title = dialogInfo.title,
            description = dialogInfo.description,
            positiveAction = dialogInfo.positiveAction,
            negativeAction = dialogInfo.negativeAction,
            onRemoveLastFromQueue = onRemoveLastMessageFromQueue
        )
    }
}