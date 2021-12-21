package com.czech.breakingbad.android.presentation.characters

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.interactors.characters.GetCharacterDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
    private val getCharacterDetail: GetCharacterDetail
): ViewModel() {

    val character: MutableState<List<Characters>?> = mutableStateOf(null)

    init {
        savedStateHandle.get<Int>("char_id")?.let { char_id ->
            getCharacterDetail(char_id)
        }
    }

    fun getCharacterDetail(char_id: Int) {
        getCharacterDetail.execute(char_id).onEach { state ->
            println("CharacterDetailVM: loading: ${state.isLoading}")

            state.data?.let { character ->
                println("CharacterDetailVM: character: $character")
                this.character.value = character
            }

            state.message?.let { message ->
                println("CharacterDetailVM: error: $message")
            }
        }.launchIn(viewModelScope)
    }
}