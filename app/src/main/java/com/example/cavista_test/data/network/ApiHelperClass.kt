package com.example.cavista_test.data.network

import com.example.cavista_test.utils.AppFunction
import javax.inject.Inject

class ApiHelperClass @Inject constructor() : ApiHelper {
    override fun fetchFeed(token: String, secret: String, count: Int) =
        AppFunction.getApiList(token, secret).fetchFeed(count)
}