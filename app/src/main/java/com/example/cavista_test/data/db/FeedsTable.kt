package com.example.cavista_test.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cavista_test.utils.AppConstants

@Entity(tableName = AppConstants.FEEDS_TABLE)
class FeedsTable(
    @PrimaryKey(autoGenerate = true)
    var pk: Long = 0,
    var feedId: Long,
    val name: String,
    val avatar: String,
    val userName: String,
    val dateCreated: String,
    val content: String,
    val comments: String,
    val retweets: String,
    val likes: String
)