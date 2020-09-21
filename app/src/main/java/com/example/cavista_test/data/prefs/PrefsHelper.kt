package com.example.cavista_test.data.prefs

interface PrefsHelper {
    fun saveUserName(userName: String)
    fun saveUserId(userId: String)
    fun saveAuthToken(token: String)
    fun saveTokenSecret(secret: String)
    fun getUserName(): String?
    fun getUserId(): String?
    fun getAuthToken(): String?
    fun getAuthTokenSecret(): String?

    fun clearPrefs()
}