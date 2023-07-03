package com.markgiannelli.sue_retirement_mobile.domain.repository

import com.markgiannelli.sue_retirement_mobile.domain.bibleverse.BibleVerseInfo
import com.markgiannelli.sue_retirement_mobile.domain.util.Resource

interface BibleVerseRepository {
    suspend fun getBibleVerseData(): Resource<BibleVerseInfo>
}