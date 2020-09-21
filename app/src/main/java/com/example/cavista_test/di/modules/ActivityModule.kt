package com.example.cavista_test.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cavista_test.screens.feed.FeedFactory
import com.example.cavista_test.screens.feed.FeedListAdapter
import com.example.cavista_test.screens.feed.FeedViewModel
import com.example.cavista_test.screens.login.LoginFactory
import com.example.cavista_test.screens.login.LoginViewModel
import com.example.cavista_test.screens.splash.SplashFactory
import com.example.cavista_test.screens.splash.SplashRepository
import com.example.cavista_test.screens.splash.SplashViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activityContext: AppCompatActivity) {
    @Provides
    fun provideLoginViewModel(factory: LoginFactory): LoginViewModel {
        return ViewModelProvider(activityContext, factory)[LoginViewModel::class.java]
    }

    @Provides
    fun provideFeedViewModel(factory: FeedFactory): FeedViewModel {
        return ViewModelProvider(activityContext, factory)[FeedViewModel::class.java]
    }

    @Provides
    fun provideSplashViewModel(factory: SplashFactory): SplashViewModel {
        return ViewModelProvider(activityContext, factory)[SplashViewModel::class.java]
    }

    @Provides
    fun provideFeedAdapter() = FeedListAdapter()

}