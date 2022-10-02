package com.czech.breakingbad.interactors.characters

import com.czech.breakingbad.datasource.cache.BreakingBadCache
import com.czech.breakingbad.datasource.network.ApiService
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.util.Constants
import com.czech.breakingbad.util.DataState
import com.czech.breakingbad.util.MessageInfo
import com.czech.breakingbad.util.UIComponentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCharactersList(
    private val apiService: ApiService,
    private val breakingBadCache: BreakingBadCache
) {

    fun execute(): Flow<DataState<List<Characters>>> = flow<DataState<List<Characters>>> {

        emit(DataState.loading())

        try {
            val characters = apiService.charactersList()

            delay(500)

            breakingBadCache.insertCharacter(characters)

            val cacheResult = breakingBadCache.getAllCharacters()

            emit(DataState.data(message = null, data = cacheResult))

        }catch (e: Exception) {
            emit(DataState.error(
                message = MessageInfo.Builder()
                    .id(Constants.CHARACTERS_LIST_ERROR)
                    .title(Constants.ERROR_TITLE)
                    .uiComponentType(UIComponentType.Dialog)
                    .description(e.message?: Constants.UNKNOWN_ERROR)
            ))
        }
    }
}