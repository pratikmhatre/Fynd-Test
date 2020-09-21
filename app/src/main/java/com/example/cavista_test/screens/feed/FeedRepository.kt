package com.example.cavista_test.screens.feed

import android.util.Log
import com.example.cavista_test.data.DataManager
import com.example.cavista_test.data.db.FeedsTable
import com.example.cavista_test.data.network.responses.FeedPojo
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class FeedRepository @Inject constructor(val dataManager: DataManager) {
    private val scope = CoroutineScope(Dispatchers.Default)

    fun getFeed() = dataManager.getAllFeeds()

    fun fetchFeed(count: Int) {
        dataManager.getAuthToken()?.run {
            dataManager.fetchFeed(
                dataManager.getAuthToken()!!,
                dataManager.getAuthTokenSecret()!!,
                count
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Response<List<FeedPojo>>> {
                    override fun onSuccess(t: Response<List<FeedPojo>>) {
                        if (t.code() == 200 && !t.body().isNullOrEmpty()) {
                            scope.launch {

                                for (feed in t.body()!!) {
                                    with(feed) {

                                        //check if the feed already exists
                                        if (dataManager.checkFeedId(id.toString().toNullSafe())
                                                .isEmpty()
                                        ) {
                                            val feedTable = FeedsTable(
                                                feedId = id,
                                                avatar = user?.profileImage.toNullSafe(),
                                                comments = "0",
                                                content = text.toNullSafe(),
                                                dateCreated = createdAt.toNullSafe(),
                                                likes = fevrtCount.toNullSafe(),
                                                name = user?.name.toNullSafe(),
                                                retweets = retweetCount.toNullSafe(),
                                                userName = user?.screenName.toNullSafe()
                                            )
                                            dataManager.insertFeed(feedTable)
                                        }

                                    }
                                }
                            }
                        }
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })

        }

    }

    fun signOut() {
        scope.launch {
            dataManager.onSignOutClicked()
        }
    }

    private fun String?.toNullSafe() = this ?: ""
}
