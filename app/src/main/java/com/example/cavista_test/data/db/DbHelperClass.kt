package com.example.cavista_test.data.db

import androidx.lifecycle.LiveData
import javax.inject.Inject

class DbHelperClass @Inject constructor(val myDatabase: MyDatabase) : DbHelper {
    override fun insertFeed(feedsTable: FeedsTable) = myDatabase.getFeedsDao().insertFeedItem(feedsTable)

    override fun getAllFeeds() = myDatabase.getFeedsDao().getAllFeeds()

    override fun clearFeeds() = myDatabase.getFeedsDao().clearFeeds()
    override fun checkFeedId(id: String) = myDatabase.getFeedsDao().checkFeedId(id)
}