package com.markgiannelli.sue_retirement_mobile.presentation

import com.markgiannelli.sue_retirement_mobile.domain.bibleverse.BibleVerseInfo

data class BibleVerseState(
    val bibleVerseInfo: BibleVerseInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
