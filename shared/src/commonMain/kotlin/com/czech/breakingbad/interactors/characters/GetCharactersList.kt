package com.czech.breakingbad.interactors.characters

import com.czech.breakingbad.datasource.cache.BreakingBadCache
import com.czech.breakingbad.datasource.network.ApiService
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCharactersList(
    private val apiService: ApiService,
    private val breakingBadCache: BreakingBadCache
) {

    fun execute(): Flow<DataState<List<Characters>>> = flow<DataState<List<Characters>>> {

        emit(DataState.loading())

        try {
            val characters = apiService.charactersList()

            breakingBadCache.insertCharacter(characters)

            val cacheResult = breakingBadCache.getAllCharacters()

            emit(DataState.data(message = null, data = cacheResult))
        }catch (e: Exception) {
            emit(DataState.error(message = e.message ?: "Unknown error"))
        }
    }
}