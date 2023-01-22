package com.example.androidprojecthomework.data

import com.example.androidprojecthomework.data.model.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    suspend fun getData(): Response<List<ItemsResponse>>
}