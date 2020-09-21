package com.example.cavista_test.data.prefs

import android.content.SharedPreferences
import javax.inject.Inject

class PrefsHelperClass @Inject constructor(val sharedPrefs: SharedPreferences) : PrefsHelper {
    private val userName = "username"
    private val userId = "userid"
    private val authToken = "authtoken"
    private val authTokenSecret = "authtokensecret"


    override fun clearPrefs() {
        sharedPrefs.edit().clear().apply()
    }

    override fun saveUserName(userName: String) {
        sharedPrefs.edit().putString(this.userName, userName).apply()
    }

    override fun saveUserId(userId: String) {
        sharedPrefs.edit().putString(this.userId, userId).apply()
    }

    override fun saveAuthToken(token: String) {
        sharedPrefs.edit().putString(this.authToken, token).apply()
    }

    override fun saveTokenSecret(secret: String)  = sharedPrefs.edit().putString(authTokenSecret, secret).apply()

    override fun getAuthTokenSecret() = sharedPrefs.getString(authTokenSecret, null)

    override fun getUserName() = sharedPrefs.getString(userName, null)

    override fun getUserId() = sharedPrefs.getString(userId, null)

    override fun getAuthToken() = sharedPrefs.getString(authToken, null)
}