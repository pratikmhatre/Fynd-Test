package com.example.cavista_test.data.network

import com.example.cavista_test.data.network.responses.FeedPojo
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiList {
    @GET("statuses/home_timeline.json")
    fun fetchFeed(@Query("count") count: Int): Single<Response<List<FeedPojo>>>
}