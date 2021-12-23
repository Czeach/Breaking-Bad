package com.czech.breakingbad.android.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.czech.breakingbad.util.NegativeAction
import com.czech.breakingbad.util.PositiveAction

@Composable
fun Dialog(
    modifier: Modifier = Modifier,
    onDismiss: (() -> Unit)?,
    title: String,
    description: String? = null,
    positiveAction: PositiveAction?,
    negativeAction: NegativeAction?,
    onRemoveLastFromQueue: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = {
            onDismiss?.invoke()
            onRemoveLastFromQueue()
        },
        text = {
            if (description != null) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.body1
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h2
            )
        },
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.End,
            ){
                if(negativeAction != null){
                    Button(
                        modifier = Modifier.padding(end = 8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        onClick = {
                            negativeAction.onNegativeAction()
                            onRemoveLastFromQueue()
                        }
                    ) {
                        Text(
                            text = negativeAction.negativeBtnTxt,
                            color = MaterialTheme.colors.error,
                            style = MaterialTheme.typography.h3
                        )
                    }
                }
                if(positiveAction != null){
                    Button(
                        modifier = Modifier.padding(end = 8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        onClick = {
                            positiveAction.onPositiveAction()
                            onRemoveLastFromQueue()
                        },
                    ) {
                        Text(
                            text = positiveAction.positiveBtnTxt,
                            color = MaterialTheme.colors.primary,
                            style = MaterialTheme.typography.h3
                        )
                    }
                }
            }
        }
    )
}