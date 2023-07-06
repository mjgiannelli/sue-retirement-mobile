package com.markgiannelli.sue_retirement_mobile.data.mappers

import com.markgiannelli.sue_retirement_mobile.data.remote.BibleVerseDataObjectDto
import com.markgiannelli.sue_retirement_mobile.domain.bibleverse.BibleVerseInfo
import com.markgiannelli.sue_retirement_mobile.domain.bibleverse.BibleVerseData

fun BibleVerseDataObjectDto.toBibleVerseInfo(): BibleVerseInfo {
    return BibleVerseInfo(bibleVerseData =
    BibleVerseData(
        bookname = this.bookname,
        chapter = this.chapter,
        text = this.text,
        verse = this.verse
    ))
}