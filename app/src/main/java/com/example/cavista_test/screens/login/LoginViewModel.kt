package com.example.cavista_test.screens.login

import androidx.lifecycle.ViewModel

class LoginViewModel(val repository: LoginRepository) : ViewModel() {
    fun saveCredentials(userId: String, userName: String, token: String, secret:String) =
        repository.saveCredentials(userId, userName, token, secret)

    fun clearFeeds() = repository.clearFeeds()
}