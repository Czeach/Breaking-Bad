package com.czech.breakingbad.android.presentation.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.czech.breakingbad.datasource.network.models.Characters

@Composable
fun CharacterDetailScreen(
    character: List<Characters>?
) {
    if(character == null){
        Text("Unable to get the details of this character...")
    }
    else{
        Column{
            Text("CharacterDetailScreen: ${character.firstOrNull()?.name}")
        }
    }
}