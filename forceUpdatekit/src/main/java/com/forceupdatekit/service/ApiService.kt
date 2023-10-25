package com.example.testcreatelibrary.ui.view.data

import com.example.demoapp.models.CheckUpdateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET()
    suspend fun getData(
        @Url url: String,
        @Query("appId") appId: String?,
        @Query("version") version: String,
        @Query("language") language: String?,
    ): Response<CheckUpdateResponse>
}