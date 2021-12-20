package com.czech.breakingbad.android.di

import com.czech.breakingbad.datasource.network.ApiService
import com.czech.breakingbad.datasource.network.ApiServiceImpl
import com.czech.breakingbad.datasource.network.KtorClientFactory
import com.czech.breakingbad.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesHttpClient(): HttpClient =
        KtorClientFactory().build()

    @Singleton
    @Provides
    fun providesApiService(
        httpClient: HttpClient
    ): ApiService =
        ApiServiceImpl(
            httpClient = httpClient,
            baseUrl = Constants.BASE_URL
        )
}