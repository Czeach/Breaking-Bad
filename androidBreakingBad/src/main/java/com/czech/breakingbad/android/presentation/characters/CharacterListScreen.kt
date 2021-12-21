package com.czech.breakingbad.android.presentation.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CharacterListScreen(
    onSelectCharacter: (Int) -> Unit
) {
    LazyColumn {
        items(50){ char_id ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onSelectCharacter(char_id)
                    }
            ){
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "CharacterId = $char_id"
                )
            }
        }
    }
}