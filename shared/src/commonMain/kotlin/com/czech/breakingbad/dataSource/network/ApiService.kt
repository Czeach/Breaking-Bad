package com.czech.breakingbad.dataSource.network

import com.czech.breakingbad.dataSource.network.models.Characters

interface ApiService {

    suspend fun charactersList(): List<Characters>

    suspend fun characterDetail(id: Int): List<Characters>
}