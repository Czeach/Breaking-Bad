package com.czech.breakingbad.presentation.characters.events

sealed class CharactersListEvent {

    object LoadCharacters: CharactersListEvent()
    object OnRemoveLastMessageFromQueue: CharactersListEvent()
}