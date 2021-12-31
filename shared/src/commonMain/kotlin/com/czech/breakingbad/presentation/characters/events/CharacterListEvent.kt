package com.czech.breakingbad.presentation.characters.events

sealed class CharactersListEvent {

    object LoadCharacters: CharactersListEvent()
    object SearchCharacter: CharactersListEvent()
    data class OnUpdateQuery(val query: String): CharactersListEvent()
    object OnRemoveLastMessageFromQueue: CharactersListEvent()
}