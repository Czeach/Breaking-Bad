package com.czech.breakingbad.interactors.characters

import com.czech.breakingbad.datasource.cache.BreakingBadCache
import com.czech.breakingbad.datasource.network.ApiService
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.util.Constants
import com.czech.breakingbad.util.DataState
import com.czech.breakingbad.util.MessageInfo
import com.czech.breakingbad.util.UIComponentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchCharacter(
    private val apiService: ApiService,
    private val breakingBadCache: BreakingBadCache,
) {

    fun execute(query: String): Flow<DataState<List<Characters>>> = flow {
        emit(DataState.loading())

        try {
            val character = apiService.searchCharacter(query)

            kotlinx.coroutines.delay(300)

            breakingBadCache.insertCharacter(character)

            val cacheResult = if (query.isBlank() || query.isEmpty()) {
                breakingBadCache.getAllCharacters()
            } else {
                breakingBadCache.searchCharacters(query)
            }

            emit(DataState.data<List<Characters>>(message = null, data = cacheResult))
        }catch (e: Exception) {
            emit(DataState.error(
                message = MessageInfo.Builder()
                    .id(Constants.SEARCH_CHARACTERS_ERROR)
                    .title(Constants.ERROR_TITLE)
                    .uiComponentType(UIComponentType.Dialog)
                    .description(e.message?: Constants.UNKNOWN_ERROR)
            ))
        }
    }
}