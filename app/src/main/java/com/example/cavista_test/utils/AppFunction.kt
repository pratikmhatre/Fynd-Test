package com.example.cavista_test.utils

import com.example.cavista_test.data.network.ApiList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer
import se.akerfeldt.okhttp.signpost.SigningInterceptor

class AppFunction {
    companion object {
        fun getApiList(token: String, secret: String): ApiList {
            val authIntercepter = OkHttpOAuthConsumer(
                "RHga97SAHC1pCujfts75wP06n",
                "FuDBXfVx25CMsVf9aGV4PRy3V7aZ5Wg1d0Qy3VmI6NPio2nNgl"
            )
            authIntercepter.setTokenWithSecret(
                token,
                secret
            )

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.HEADERS

            val httpClient =
                OkHttpClient().newBuilder().addInterceptor(SigningInterceptor(authIntercepter))
                    .addInterceptor(logging).build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.twitter.com/1.1/")
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiList::class.java)
        }
    }
}