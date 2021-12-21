package com.czech.breakingbad.android.presentation.characters

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.czech.breakingbad.interactors.characters.GetCharactersList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getCharactersList: GetCharactersList
): ViewModel() {

    init {
        getCharacters()
    }

    private fun getCharacters() {
        getCharactersList.execute().onEach { state ->
            println("CharacterListVM: Loading: ${state.isLoading}")

            state.data.let { characters ->
                println("CharacterListVM: characters: $characters")
            }

            state.message.let { message ->
                println("CharacterListVM: error: $message")
            }
        }.launchIn(viewModelScope)
    }
}