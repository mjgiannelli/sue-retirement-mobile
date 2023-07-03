package com.markgiannelli.sue_retirement_mobile.data.mappers

import com.markgiannelli.sue_retirement_mobile.data.remote.BibleVerseDataDto
import com.markgiannelli.sue_retirement_mobile.data.remote.BibleVerseDto
import com.markgiannelli.sue_retirement_mobile.domain.bibleverse.BibleVerseInfo
import com.markgiannelli.sue_retirement_mobile.domain.bibleverse.BibleVerseData

private data class IndexedWeatherData(
    val data: BibleVerseData
)

fun BibleVerseDataDto.toBibleVerseData(): BibleVerseData {
    return BibleVerseData(
        bookname = bookname,
        chapter = chapter,
        text = text,
        verse = verse
    )
}

fun BibleVerseDto.toBibleVerseInfo(): BibleVerseInfo {
    val bibleVerseData = bibleVerseData.first().toBibleVerseData();
    return BibleVerseInfo(bibleVerseData = bibleVerseData)
}