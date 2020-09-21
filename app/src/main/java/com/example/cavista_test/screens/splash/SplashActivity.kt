package com.example.cavista_test.screens.splash

import android.content.Intent
import android.os.Bundle
import com.example.cavista_test.screens.feed.FeedActivity
import com.example.cavista_test.screens.login.LoginActivity
import com.example.cavista_test.utils.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)

        if (splashViewModel.isUserLoggedIn()) {
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}