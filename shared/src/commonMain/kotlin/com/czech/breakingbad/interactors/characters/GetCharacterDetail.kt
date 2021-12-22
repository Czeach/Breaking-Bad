package com.czech.breakingbad.interactors.characters

import com.czech.breakingbad.datasource.cache.BreakingBadCache
import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.util.Constants
import com.czech.breakingbad.util.DataState
import com.czech.breakingbad.util.MessageInfo
import com.czech.breakingbad.util.UIComponentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCharacterDetail(
    private val breakingBadCache: BreakingBadCache
) {

    fun execute(char_id: Int): Flow<DataState<List<Characters>>> = flow {

        emit(DataState.loading())

        try {
            val character = breakingBadCache.getCharacterById(char_id)

            emit(DataState.data(message = null, data = character))

        }catch (e: Exception) {
            emit(DataState.error(
                message = MessageInfo.Builder()
                    .id(Constants.CHARACTERS_DETAIL_ERROR)
                    .title(Constants.ERROR_TITLE)
                    .uiComponentType(UIComponentType.Dialog)
                    .description(e.message ?: Constants.UNKNOWN_ERROR)
            ))
        }
    }
}