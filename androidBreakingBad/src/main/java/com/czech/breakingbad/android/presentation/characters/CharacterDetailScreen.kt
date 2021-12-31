package com.czech.breakingbad.android.presentation.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.czech.breakingbad.android.presentation.components.CharacterDetail
import com.czech.breakingbad.android.presentation.theme.AppTheme
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.presentation.characters.events.CharacterDetailEvent
import com.czech.breakingbad.presentation.characters.states.CharacterDetailState

@Composable
fun CharacterDetailScreen(
    state: CharacterDetailState,
    triggerEvent: (CharacterDetailEvent) -> Unit
) {

    AppTheme(
        displayProgressBar = state.isLoading,
        dialogQueue = state.queue,
        onRemoveLastMessageFromQueue = {
            triggerEvent(CharacterDetailEvent.OnRemoveLastMessageFromQueue)
        }
    ) {
        if (state.character == null) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Unable to retrieve the details for this character.",
                style = MaterialTheme.typography.body1
            )
        } else {
            CharacterDetail(character = state.character)
        }
    }
}