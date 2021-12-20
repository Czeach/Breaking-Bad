package com.czech.breakingbad.datasource.network

import com.czech.breakingbad.datasource.network.models.Characters

interface ApiService {

    suspend fun charactersList(): List<Characters>

    suspend fun characterDetail(id: Int): List<Characters>
}