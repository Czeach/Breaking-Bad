package com.czech.breakingbad.android.di

import com.czech.breakingbad.datasource.cache.BreakingBadCache
import com.czech.breakingbad.datasource.network.ApiService
import com.czech.breakingbad.interactors.characters.GetCharacterDetail
import com.czech.breakingbad.interactors.characters.GetCharactersList
import com.czech.breakingbad.interactors.characters.SearchCharacter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InterectorsModule {

    @Singleton
    @Provides
    fun providesGetCharactersList(
        apiService: ApiService,
        breakingBadCache: BreakingBadCache
    ): GetCharactersList =
        GetCharactersList(
            apiService = apiService,
            breakingBadCache = breakingBadCache
        )

    @Singleton
    @Provides
    fun provideSearchCharacter(
        apiService: ApiService,
        breakingBadCache: BreakingBadCache
    ): SearchCharacter =
        SearchCharacter(
            apiService = apiService,
            breakingBadCache = breakingBadCache
        )

    @Singleton
    @Provides
    fun providesGetCharacterDetail(
        breakingBadCache: BreakingBadCache
    ): GetCharacterDetail =
        GetCharacterDetail(
            breakingBadCache = breakingBadCache
        )
}