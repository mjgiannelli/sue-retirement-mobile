package com.markgiannelli.sue_retirement_mobile.data.remote

import com.squareup.moshi.Json

data class BibleVerseDataObjectDto(
    @field:Json(name = "bookname")
    val bookname: String,
    @field:Json(name = "chapter")
    val chapter: String,
    @field:Json(name = "text")
    val text: String,
    @field:Json(name = "verse")
    val verse: String
)