package com.example.cavista_test.screens.splash

import com.example.cavista_test.data.DataManager
import javax.inject.Inject

class SplashRepository @Inject constructor(val dataManager: DataManager) {
    fun isUserLoggedIn() = !dataManager.getAuthToken().isNullOrBlank()
}