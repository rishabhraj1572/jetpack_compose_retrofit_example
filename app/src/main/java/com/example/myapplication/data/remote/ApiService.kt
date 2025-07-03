package com.example.myapplication.data.remote

import com.example.myapplication.data.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/users?page=2")
    suspend fun getItems(): ApiResponse
}
