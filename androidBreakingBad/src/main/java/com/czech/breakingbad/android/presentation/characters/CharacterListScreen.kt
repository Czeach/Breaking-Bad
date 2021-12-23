package com.czech.breakingbad.android.presentation.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.czech.breakingbad.android.presentation.components.CharactersList
import com.czech.breakingbad.android.presentation.theme.AppTheme
import com.czech.breakingbad.presentation.characters.events.CharactersListEvent
import com.czech.breakingbad.presentation.characters.states.CharactersListState

@Composable
fun CharacterListScreen(
    state: CharactersListState,
    onTriggerEvents: (CharactersListEvent) -> Unit,
    onSelectCharacter: (Int) -> Unit
) {
    AppTheme(
        displayProgressBar = state.isLoading,
        dialogQueue = state.queue,
        onRemoveLastMessageFromQueue = { onTriggerEvents(CharactersListEvent.OnRemoveLastMessageFromQueue) }
    ) {
        CharactersList(
            loading = state.isLoading,
            characters = state.characters,
            onClickCharacterListItem = onSelectCharacter)
    }
}