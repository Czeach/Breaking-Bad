package com.czech.breakingbad.android.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
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