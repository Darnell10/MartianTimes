package com.example.martiantimes.model


import com.google.gson.annotations.SerializedName

data class MartianResponse(

    @SerializedName("title")
    val title: String?,
    @SerializedName("images")
    val images: List<Image?>?,
    @SerializedName("body")
    val body: String?
)

data class Image(
    @SerializedName("top_image")
    val topImage: Boolean?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?
)