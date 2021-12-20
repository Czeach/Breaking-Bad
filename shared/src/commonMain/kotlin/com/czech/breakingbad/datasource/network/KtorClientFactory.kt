package com.czech.breakingbad.datasource.network

import io.ktor.client.*

expect class KtorClientFactory() {

    fun build(): HttpClient
}