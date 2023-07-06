package com.markgiannelli.sue_retirement_mobile.data.repository

import com.markgiannelli.sue_retirement_mobile.data.mappers.toBibleVerseInfo
import com.markgiannelli.sue_retirement_mobile.data.remote.BibleVerseApi
import com.markgiannelli.sue_retirement_mobile.domain.bibleverse.BibleVerseInfo
import com.markgiannelli.sue_retirement_mobile.domain.repository.BibleVerseRepository
import com.markgiannelli.sue_retirement_mobile.domain.util.Resource
import java.lang.Exception
import javax.inject.Inject

class BibleVerseRepositoryImpl @Inject constructor(
    private val api: BibleVerseApi
): BibleVerseRepository {
    override suspend fun getBibleVerseData(): Resource<BibleVerseInfo> {
        return try {
            Resource.Success(
                data = api.getBibleVerseData().first().toBibleVerseInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "An unknown error occurred")
        }
    }
}