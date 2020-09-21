package com.example.cavista_test.screens.feed

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cavista_test.databinding.ActivityFeedBinding
import com.example.cavista_test.screens.login.LoginActivity
import com.example.cavista_test.utils.BaseActivity
import javax.inject.Inject

class FeedActivity : BaseActivity() {
    @Inject
    lateinit var feedViewModel: FeedViewModel

    @Inject
    lateinit var feedListAdapter: FeedListAdapter

    private var listSize = 0

    private lateinit var feedBinding: ActivityFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        feedBinding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(feedBinding.root)

        feedBinding.feedActivity = this
        feedBinding.recyclerFeeds.apply {
            layoutManager = LinearLayoutManager(this@FeedActivity)
            adapter = feedListAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView.canScrollVertically(1)) {
                        fetchFeeds()
                    }
                }
            })
        }

        feedViewModel.getFeed().observe(this, Observer {
            it?.run {
                feedListAdapter.addFeedData(this)
                listSize = it.size
            }
        })

        fetchFeeds()

    }

    private fun fetchFeeds() {
        showToast("Loading")
        listSize += 10
        feedViewModel.fetchFeeds(listSize)
    }

    fun onLogoutClicked(v: View) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            title = "Sign Out"
            setMessage("Confirm Sign Out ?")
            setPositiveButton("Yes") { v, i ->
                onSignOutConfirmed()
                v.dismiss()

            }
            setNegativeButton("No") { v, i ->
                v.dismiss()
            }
            show()
        }
    }

    private fun onSignOutConfirmed() {
        feedViewModel.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}