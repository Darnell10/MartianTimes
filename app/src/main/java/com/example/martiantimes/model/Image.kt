package com.example.martiantimes.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("top_image")
    val topImage: Boolean?,
    val url: String?,
    val width: Int?,
    val height: Int?
)