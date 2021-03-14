package com.ossovita.artbooktesting.api

import com.ossovita.artbooktesting.model.ImageResponse
import com.ossovita.artbooktesting.util.Util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    @GET("/api/")
    suspend fun imageSearch(//parametre olarak String searchQuery ve String apiKey alır
        @Query("q") searchQuery: String,
        @Query("key") apiKEY : String = API_KEY
    ):Response<ImageResponse> //bu metod bize ImageResponse türünde veri döndürür
}