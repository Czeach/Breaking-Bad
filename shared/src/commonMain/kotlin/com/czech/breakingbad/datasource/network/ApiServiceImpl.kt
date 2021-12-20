package com.czech.breakingbad.datasource.network

import com.czech.breakingbad.datasource.network.models.Characters
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
}