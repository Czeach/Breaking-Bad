package com.czech.breakingbad.datasource.cache

import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.util.SQLDelightConverters.toCharactersList

class BreakingBadCacheImpl(
    breakingBadDatabase: BreakingBadDatabase
): BreakingBadCache {

    private val queries:BreakingBadDBQueries = breakingBadDatabase.breakingBadDBQueries

    override fun insertCharacter(characters: Characters) {
        queries.insertCharacter(
            char_id = characters.charId.toLong(),
            name = characters.name,
            birthday = characters.birthday,
            occupation = characters.occupation,
            status = characters.status,
            img = characters.img,
            nickname = characters.nickname,
            appearance = characters.appearance,
            portrayed = characters.portrayed,
            category = characters.category,
            better_call_saul_appearance = characters.betterCallSaulAppearance
        )
    }

    override fun insertCharacter(characters: List<Characters>) {
        for (character in characters) {
            insertCharacter(character)
        }
    }

    override fun getAllCharacters(): List<Characters> {
        return queries.getAllCharacters().executeAsList().toCharactersList()
    }

    override fun searchCharacters(query: String): List<Characters> {
        return queries.searchCharacter(
            query = query
        ).executeAsList().toCharactersList()
    }

    override fun getCharacterById(char_id: Int): List<Characters>? {
        return try {
            queries.getcharacterById(
                char_id = char_id.toLong()
            ).executeAsList().toCharactersList()
        } catch (e: NullPointerException) {
            null
        }
    }
}