package com.czech.breakingbad.android.presentation.characters

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.interactors.characters.GetCharactersList
import com.czech.breakingbad.presentation.characters.events.CharactersListEvent
import com.czech.breakingbad.presentation.characters.states.CharactersListState
import com.czech.breakingbad.util.Constants
import com.czech.breakingbad.util.MessageInfo
import com.czech.breakingbad.util.MessageInfoQueueUtil
import com.czech.breakingbad.util.Queue
import com.czech.breakingbad.util.UIComponentType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class CharactersListViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getCharactersList: GetCharactersList
): ViewModel() {

    val state: MutableState<CharactersListState> = mutableStateOf(CharactersListState())

    init {
        triggerEvent(CharactersListEvent.LoadCharacters)
    }

    fun triggerEvent(event: CharactersListEvent) {
        when (event) {
            is CharactersListEvent.LoadCharacters -> {
                loadCharacters()
            }
            is CharactersListEvent.OnRemoveLastMessageFromQueue -> {
                removeLastMessage()
            }
            else -> {
                val messageInfoBuilder = MessageInfo.Builder()
                    .id(UUID.randomUUID().toString())
                    .title(Constants.UNKNOWN_EVENT)
                    .uiComponentType(UIComponentType.Dialog)
                    .description(Constants.UNKNOWN_ERROR)
                appendToMessageQueue(messageInfo = messageInfoBuilder)
            }
        }
//        getCharactersList.execute().onEach { state ->
//            println("CharacterListVM: Loading: ${state.isLoading}")
//
//            state.data.let { characters ->
//                println("CharacterListVM: characters: $characters")
//            }
//
//            state.message.let { message ->
//                println("CharacterListVM: error: $message")
//            }
//        }.launchIn(viewModelScope)
    }

    private fun loadCharacters() {
        getCharactersList.execute()
            .onEach { dataState ->
                state.value = state.value.copy(dataState.isLoading)

                dataState.data.let { data ->
                    if (data != null) {
                        appendCharacters(characters = data)
                    }
                }

                dataState.message.let { message ->
                    if (message != null) {
                        appendToMessageQueue(message)
                    }
                }
            }.launchIn(viewModelScope)
    }

    private fun appendCharacters(characters: List<Characters>) {
        val charactersList = ArrayList(state.value.characters)
        charactersList.addAll(characters)
        state.value = state.value.copy(characters = charactersList)
    }

    private fun appendToMessageQueue(messageInfo: MessageInfo.Builder) {
        if (!MessageInfoQueueUtil()
                .doesMessageAlreadyExistInQueue(queue = state.value.queue, messageInfo = messageInfo.build())
        ) {
            val queue = state.value.queue
            queue.add(messageInfo.build())
            state.value = state.value.copy(queue = queue)
        }
    }

    private fun removeLastMessage() {
        try {
            val queue = state.value.queue
            queue.remove()
            state.value = state.value.copy(queue = Queue(mutableListOf()))
            state.value = state.value.copy(queue = queue)
        }catch (e: Exception) {

        }
    }
}