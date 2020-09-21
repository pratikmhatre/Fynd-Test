package com.example.cavista_test.data

import com.example.cavista_test.data.db.DbHelperClass
import com.example.cavista_test.data.db.FeedsTable
import com.example.cavista_test.data.network.ApiHelperClass
import com.example.cavista_test.data.prefs.PrefsHelperClass
import javax.inject.Inject

class DataManagerClass @Inject constructor(
    var apiHelper: ApiHelperClass,
    val dbHelperClass: DbHelperClass, val prefsHelperClass: PrefsHelperClass
) : DataManager {
    override fun saveUserName(userName: String) {
        prefsHelperClass.saveUserName(userName)
    }

    override fun saveUserId(userId: String) {
        prefsHelperClass.saveUserId(userId)
    }

    override fun saveAuthToken(token: String) {
        prefsHelperClass.saveAuthToken(token)
    }

    override fun getUserName() = prefsHelperClass.getUserName()

    override fun getUserId() = prefsHelperClass.getUserId()

    override fun getAuthToken() = prefsHelperClass.getAuthToken()
    override fun clearPrefs() = prefsHelperClass.clearPrefs()

    override fun fetchFeed(token: String, secret: String, count: Int) =
        apiHelper.fetchFeed(token, secret, count)


    override fun insertFeed(feedsTable: FeedsTable) = dbHelperClass.insertFeed(feedsTable)

    override fun getAllFeeds() = dbHelperClass.getAllFeeds()

    override fun clearFeeds() = dbHelperClass.clearFeeds()

    override fun checkFeedId(id: String) = dbHelperClass.checkFeedId(id)

    override fun onSignOutClicked() {
        dbHelperClass.clearFeeds()
        prefsHelperClass.clearPrefs()
    }

    override fun saveTokenSecret(secret: String) = prefsHelperClass.saveTokenSecret(secret)
    override fun getAuthTokenSecret() = prefsHelperClass.getAuthTokenSecret()
}