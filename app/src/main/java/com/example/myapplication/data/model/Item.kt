package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    val data: List<Item>
)

data class Item(
    val last_name:String,
    @SerializedName("first_name")
    val name: String
)