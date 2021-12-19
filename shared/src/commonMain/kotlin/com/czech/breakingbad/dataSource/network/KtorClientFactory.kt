package com.czech.breakingbad.dataSource.network

import io.ktor.client.*

expect class KtorClientFactory() {

    fun build(): HttpClient
}