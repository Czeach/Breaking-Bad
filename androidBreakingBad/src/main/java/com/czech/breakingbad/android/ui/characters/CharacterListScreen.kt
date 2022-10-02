package com.czech.breakingbad.android.ui.characters

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.czech.breakingbad.android.ui.components.CharactersList
import com.czech.breakingbad.android.ui.components.SearchBar
import com.czech.breakingbad.android.ui.theme.AppTheme
import com.czech.breakingbad.presentation.characters.events.CharactersListEvent
import com.czech.breakingbad.presentation.characters.states.CharactersListState

@ExperimentalComposeUiApi
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

        Scaffold(
            topBar = {
                SearchBar(
                    query = state.query,
                    onQueryChanged = {
                        onTriggerEvents(CharactersListEvent.OnUpdateQuery(it))
                    },
                    onSearchExecuted = {
                        onTriggerEvents(CharactersListEvent.SearchCharacter)
                    }
                )
            },
        ) {
            CharactersList(
                loading = state.isLoading,
                characters = state.characters,
                onClickCharacterListItem = onSelectCharacter
            )
        }
    }
}