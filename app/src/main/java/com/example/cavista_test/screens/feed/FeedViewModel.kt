package com.example.cavista_test.screens.feed

import androidx.lifecycle.ViewModel

class FeedViewModel(private val repository: FeedRepository) : ViewModel() {
    fun getFeed() = repository.getFeed()
    fun fetchFeeds(count:Int) {
        repository.fetchFeed(count)
    }

    fun signOut() = repository.signOut()
}