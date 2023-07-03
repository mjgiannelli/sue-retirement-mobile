package com.markgiannelli.sue_retirement_mobile.di

import com.markgiannelli.sue_retirement_mobile.data.remote.BibleVerseApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBibleVerseApi(): BibleVerseApi {
        return Retrofit.Builder()
            .baseUrl("https://labs.bible.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
}