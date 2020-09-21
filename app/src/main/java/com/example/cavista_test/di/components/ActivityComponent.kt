package com.example.cavista_test.di.components

import com.example.cavista_test.di.annotations.PerActivity
import com.example.cavista_test.di.modules.ActivityModule
import com.example.cavista_test.screens.feed.FeedActivity
import com.example.cavista_test.screens.login.LoginActivity
import com.example.cavista_test.screens.splash.SplashActivity
import dagger.Component

@PerActivity
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
interface ActivityComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(feedActivity: FeedActivity)
    fun inject(splashActivity: SplashActivity)
}