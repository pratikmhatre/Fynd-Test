package com.example.cavista_test.data.network

import com.example.cavista_test.data.network.responses.FeedPojo
import io.reactivex.Single
import retrofit2.Response

interface ApiHelper {
    fun fetchFeed(token: String, secret: String, count: Int): Single<Response<List<FeedPojo>>>
}