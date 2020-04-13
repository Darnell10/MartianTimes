package com.example.martiantimes.model

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MartianApi {

    @GET("ios-newsreader/candidates/test/articles.json")
    fun getArticles(): Deferred<List<MartianResponse>>


}