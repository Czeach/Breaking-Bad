package com.czech.breakingbad.util

import com.czech.breakingbad.datasource.network.models.Characters
import com.czech.breakingbad.datasource.cache.Characters_Entity
import com.squareup.sqldelight.ColumnAdapter

object SQLDelightConverters {

    val listOfStringsAdapter = object : ColumnAdapter<List<String>, String> {
        override fun decode(databaseValue: String): List<String> {
            return if (databaseValue.isEmpty()) {
                listOf()
            } else {
                databaseValue.split(",")
            }
        }
        override fun encode(value: List<String>): String {
            return value.joinToString(separator = ",")
        }

    }

    val listOfIntsAdapter = object : ColumnAdapter<List<Int>, String> {
        override fun decode(databaseValue: String): List<Int> {
            return if (databaseValue.isEmpty()) {
                listOf()
            } else {
                databaseValue.split(",").map{ it.toInt() }
            }
        }
        override fun encode(value: List<Int>): String {
            return value.joinToString(separator = ",")
        }

    }

    private fun Characters_Entity.toCharacters(): Characters {
        return Characters(
            charId = char_id.toInt(),
            name = name,
            birthday = birthday,
            occupation = occupation,
            img = img,
            status = status,
            nickname = nickname,
            appearance = appearance,
            portrayed = portrayed,
            category = category,
            betterCallSaulAppearance = better_call_saul_appearance
        )
    }

    fun List<Characters_Entity>.toCharactersList(): List<Characters> {
        return map { it.toCharacters() }
    }
}