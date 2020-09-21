package com.example.cavista_test.data.db

import androidx.lifecycle.LiveData

interface DbHelper {
    fun insertFeed(feedsTable: FeedsTable)
    fun getAllFeeds(): LiveData<List<FeedsTable>>
    fun clearFeeds()
    fun checkFeedId(id: String): List<Long>

}