package com.markgiannelli.sue_retirement_mobile.di

import com.markgiannelli.sue_retirement_mobile.data.repository.BibleVerseRepositoryImpl
import com.markgiannelli.sue_retirement_mobile.domain.repository.BibleVerseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindBibleVerseRepository(
        bibleVerseRepositoryImpl: BibleVerseRepositoryImpl
    ): BibleVerseRepository
}