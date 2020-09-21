package com.example.cavista_test.screens.login

import com.example.cavista_test.data.DataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginRepository @Inject constructor(val dataManager: DataManager) {
    private val scope = CoroutineScope(Dispatchers.Default)
    fun saveCredentials(
        userId: String,
        userName: String,
        authToken: String,
        secret: String
    ) {
        dataManager.saveUserId(userId)
        dataManager.saveUserName(userName)
        dataManager.saveAuthToken(authToken)
        dataManager.saveTokenSecret(secret)
    }

    fun clearFeeds() {
        scope.launch {
            dataManager.clearFeeds()
        }
    }
}