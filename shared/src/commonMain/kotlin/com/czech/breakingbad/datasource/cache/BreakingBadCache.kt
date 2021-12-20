package com.czech.breakingbad.datasource.cache

import com.czech.breakingbad.datasource.network.models.Characters

interface BreakingBadCache {

    fun insertCharacter(characters: Characters)

    fun insertCharacter(characters: List<Characters>)

    fun getAllCharacters(): List<Characters>

    @Throws(NullPointerException::class)
    fun getCharacterById(char_id: Int): List<Characters>?
}