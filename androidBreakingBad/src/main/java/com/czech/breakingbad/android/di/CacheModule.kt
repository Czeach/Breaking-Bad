package com.czech.breakingbad.android.di

import com.czech.breakingbad.android.BaseApplication
import com.czech.breakingbad.datasource.cache.BreakingBadCache
import com.czech.breakingbad.datasource.cache.BreakingBadCacheImpl
import com.czech.breakingbad.datasource.cache.BreakingBadDatabaseFactory
import com.czech.breakingbad.datasource.cache.DriverFactory
import com.czech.breakingbad.datasource.cache.BreakingBadDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun providesBreakingBadDatabase(
        context: BaseApplication
    ): BreakingBadDatabase =
        BreakingBadDatabaseFactory(
            driverFactory = DriverFactory(context = context)
        ).createDatabase()

    @Singleton
    @Provides
    fun providesBreakingBadCache(
        breakingBadDatabase: BreakingBadDatabase
    ): BreakingBadCache =
        BreakingBadCacheImpl (
            breakingBadDatabase = breakingBadDatabase
        )
}