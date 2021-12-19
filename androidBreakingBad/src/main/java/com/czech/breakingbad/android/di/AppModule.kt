package com.czech.breakingbad.android.di

import android.content.Context
import com.czech.breakingbad.android.MyApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext myApp: Context): MyApplication {
        return myApp as MyApplication
    }
}