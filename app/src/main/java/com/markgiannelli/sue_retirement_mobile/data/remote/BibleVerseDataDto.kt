package com.markgiannelli.sue_retirement_mobile.data.remote

import com.markgiannelli.sue_retirement_mobile.domain.bibleverse.BibleVerseData
import com.squareup.moshi.Json

data class BibleVerseDataDto(
    @field:Json(name = "bookname")
    val bookname: String,
    @field:Json(name = "chapter")
    val chapter: String,
    @field:Json(name = "text")
    val text: String,
    @field:Json(name = "verse")
    val verse: String
)