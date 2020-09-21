package com.example.cavista_test.application

import android.app.Application
import com.example.cavista_test.R
import com.example.cavista_test.di.components.AppComponent
import com.example.cavista_test.di.components.DaggerAppComponent
import com.example.cavista_test.di.modules.AppModule
import com.facebook.drawee.backends.pipeline.Fresco
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig

class MyApplication : Application() {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        Fresco.initialize(this)
        val authConfig = TwitterAuthConfig(
            getString(R.string.twitter_consumer_key),
            getString(R.string.twitter_consumer_secret)
        )
        val twitterConfig = TwitterConfig.Builder(this).twitterAuthConfig(authConfig).build()
        Twitter.initialize(twitterConfig)

    }

    fun getAppComponent() = appComponent
}