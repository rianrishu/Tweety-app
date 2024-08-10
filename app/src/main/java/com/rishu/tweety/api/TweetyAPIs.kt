package com.rishu.tweety.api

import com.rishu.tweety.models.TweetList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetyAPIs {

    @GET("v3/b/66b74a5aacd3cb34a872a608?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<TweetList>

    @GET("v3/b/66b74a5aacd3cb34a872a608?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
}