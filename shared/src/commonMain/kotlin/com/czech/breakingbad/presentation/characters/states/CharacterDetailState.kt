package com.czech.breakingbad.presentation.characters.states

import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.util.MessageInfo
import com.czech.breakingbad.util.Queue

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: List<Characters> = listOf(),
    val queue: Queue<MessageInfo> = Queue(mutableListOf())
)
