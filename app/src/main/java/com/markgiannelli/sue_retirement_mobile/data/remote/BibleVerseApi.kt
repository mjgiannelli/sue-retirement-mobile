package com.markgiannelli.sue_retirement_mobile.data.remote

import retrofit2.http.GET

interface BibleVerseApi {
    @GET("api/?passage=votd&type=json")
    suspend fun getBibleVerseData() : List<BibleVerseDataDto>
}