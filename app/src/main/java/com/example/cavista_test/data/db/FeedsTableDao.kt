package com.example.cavista_test.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cavista_test.utils.AppConstants

@Dao
interface FeedsTableDao {
    @Query("select * from ${AppConstants.FEEDS_TABLE} order by feedId desc")
    fun getAllFeeds(): LiveData<List<FeedsTable>>

    @Insert
    fun insertFeedItem(feedsTable: FeedsTable)

    @Query("delete from ${AppConstants.FEEDS_TABLE}")
    fun clearFeeds()

    @Query("select pk from ${AppConstants.FEEDS_TABLE} where feedId = :id")
    fun checkFeedId(id: String): List<Long>
}