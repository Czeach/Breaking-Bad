package com.czech.breakingbad.interactors.characters

import com.czech.breakingbad.datasource.cache.BreakingBadCache
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCharacterDetail(
    private val breakingBadCache: BreakingBadCache
) {

    fun execute(char_id: Int): Flow<DataState<List<Characters>>> = flow {
        try {
            emit(DataState.loading())

            val character = breakingBadCache.getCharacterById(char_id)

            emit(DataState.data(message = null, data = character))

        }catch (e: Exception) {
            emit(DataState.error(message = e.message ?: "Unknown error"))
        }
    }
}