package com.czech.breakingbad.android.presentation.characters

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.interactors.characters.GetCharacterDetail
import com.czech.breakingbad.presentation.characters.events.CharacterDetailEvent
import com.czech.breakingbad.presentation.characters.states.CharacterDetailState
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

@HiltViewModel
class CharacterDetailViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
    private val getCharacterDetail: GetCharacterDetail
): ViewModel() {

    val state: MutableState<CharacterDetailState> = mutableStateOf(CharacterDetailState())

    init {
        savedStateHandle.get<Int>("char_id")?.let { char_id ->
            triggerEvent(CharacterDetailEvent.GetCharacter(char_Id = char_id))
        }
    }

    fun triggerEvent(event: CharacterDetailEvent) {
        when (event) {
            is CharacterDetailEvent.GetCharacter -> {
                getCharacter(char_id = event.char_Id)
            }
            is CharacterDetailEvent.OnRemoveLastMessageFromQueue -> {
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
    }

    private fun getCharacter(char_id: Int) {
        getCharacterDetail.execute(char_id)
            .onEach { dataState ->
                state.value = state.value.copy(isLoading = dataState.isLoading)

                dataState.data.let { data ->
                    if (data != null) {
                        state.value = state.value.copy(character = data)
                    }
                }

                dataState.message.let { message ->
                    if (message != null) {
                        appendToMessageQueue(message)
                    }
                }
            }.launchIn(viewModelScope)
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

//    fun getCharacterDetail(char_id: Int) {
//        getCharacterDetail.execute(char_id).onEach { state ->
//            println("CharacterDetailVM: loading: ${state.isLoading}")
//
//            state.data?.let { character ->
//                println("CharacterDetailVM: character: $character")
//                this.character.value = character
//            }
//
//            state.message?.let { message ->
//                println("CharacterDetailVM: error: $message")
//            }
//        }.launchIn(viewModelScope)
//    }
}