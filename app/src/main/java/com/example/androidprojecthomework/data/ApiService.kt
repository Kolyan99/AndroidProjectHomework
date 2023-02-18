package com.example.androidprojecthomework.data

import com.example.androidprojecthomework.data.model.ItemsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
     fun getData(): Single<ItemsResponse>

}