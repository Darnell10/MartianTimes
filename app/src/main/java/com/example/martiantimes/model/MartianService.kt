package com.example.martiantimes.model

import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MartianService {

    private val BASE_URL = "https://s1.nyt.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MartianApi::class.java)

    fun getArticles(): Deferred<List<MartianResponse>> {
        return retrofit.getArticles()
    }

}