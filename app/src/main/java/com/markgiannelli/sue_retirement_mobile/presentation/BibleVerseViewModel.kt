package com.markgiannelli.sue_retirement_mobile.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.markgiannelli.sue_retirement_mobile.domain.repository.BibleVerseRepository
import com.markgiannelli.sue_retirement_mobile.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BibleVerseViewModel @Inject constructor(
    private val repository: BibleVerseRepository
): ViewModel() {
    var state by mutableStateOf(BibleVerseState())
        private set

    fun loadBibleVerseInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            when(val result = repository.getBibleVerseData()) {
                is Resource.Success -> {
                    state = state.copy(
                        bibleVerseInfo = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        bibleVerseInfo = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}