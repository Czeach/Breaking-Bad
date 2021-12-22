package com.czech.breakingbad.presentation.characters.events

sealed class CharacterDetailEvent {

    data class GetCharacter(val char_Id: Int): CharacterDetailEvent()

    object OnRemoveLastMessageFromQueue: CharacterDetailEvent()

}