package com.czech.breakingbad.android.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.czech.breakingbad.datasource.network.models.Characters

@Composable
fun CharactersList(
    loading: Boolean,
    characters: List<Characters>,
    onClickCharacterListItem: (Int) -> Unit
) {
    Box(

    ) {
        if (loading && characters.isEmpty()) {

        } else if (characters.isEmpty()) {

        } else {
            LazyColumn {
                items(
                    items = characters
                ) { item ->
                    CharacterListItem(
                        characters = item
                    ) { onClickCharacterListItem(item.charId) }
                }
            }
        }
    }
}