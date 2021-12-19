package com.czech.breakingbad.dataSource.network

import com.czech.breakingbad.dataSource.network.models.Characters
import io.ktor.client.*
import io.ktor.client.request.*

class ApiServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
): ApiService {
    override suspend fun charactersList(): List<Characters> {
        return httpClient.get {
            url("$baseUrl/characters")
        }
    }

    override suspend fun characterDetail(id: Int): List<Characters> {
        return httpClient.get {
            url("$baseUrl/characters/$id")
        }
    }

    companion object {
        const val BASE_URL = "https://www.breakingbadapi.com/api"
    }
}