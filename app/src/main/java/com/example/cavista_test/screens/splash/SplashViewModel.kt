package com.example.cavista_test.screens.splash

import androidx.lifecycle.ViewModel

class SplashViewModel(private val repository: SplashRepository) : ViewModel() {
    fun isUserLoggedIn() = repository.isUserLoggedIn()
}