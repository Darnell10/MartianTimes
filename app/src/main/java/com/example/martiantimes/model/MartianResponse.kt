package com.example.martiantimes.model


import com.google.gson.annotations.SerializedName

data class MartianResponse(
    val title: String?,
    val images: List<Image?>?,
    val body: String?
)