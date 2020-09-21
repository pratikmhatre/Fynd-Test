package com.example.cavista_test.screens.feed

import android.graphics.Color
import android.text.SpannableString
import android.text.format.DateUtils
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cavista_test.data.db.FeedsTable
import com.example.cavista_test.databinding.ItemFeedBinding
import com.example.cavista_test.utils.FeedDiffCallbacks
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.collections.ArrayList

class FeedListAdapter : RecyclerView.Adapter<FeedListAdapter.FeedHolder>() {
    private val arrayList = ArrayList<FeedsTable>()

    inner class FeedHolder(private val itemBinding: ItemFeedBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindFeed(feedsTable: FeedsTable, position: Int) {
            itemBinding.apply {
                name = feedsTable.name
                username = "@${feedsTable.userName}"
                time = getRelativeTime(feedsTable.dateCreated)
                text = getSpannedString(feedsTable.content)
                comments = feedsTable.comments
                retweets = feedsTable.retweets
                likes = feedsTable.likes
                ivAvatar.setImageURI(feedsTable.avatar)
            }
        }
    }

    private fun getSpannedString(input: String): SpannableString {
        val span = SpannableString(input)
        val hashMatcher = Pattern.compile("#\\w+").matcher(span)
        val alphaMatcher = Pattern.compile("@\\w+").matcher(span)
        val linkMatcher =
            Pattern.compile("https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_+.~#?&//=]*)")
                .matcher(span)

        setSpan(hashMatcher, span)
        setSpan(alphaMatcher, span)
        setSpan(linkMatcher, span)

        return span
    }

    private fun setSpan(matcher: Matcher, span: SpannableString) {
        while (matcher.find()) {
            span.setSpan(
                ForegroundColorSpan(Color.BLUE),
                matcher.start(),
                matcher.end(),
                0
            );
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedHolder {
        val rootBinding =
            ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedHolder(rootBinding)
    }

    override fun getItemCount() = arrayList.size

    override fun onBindViewHolder(holder: FeedHolder, position: Int) {
        holder.bindFeed(arrayList[position], position)
    }

    fun addFeedData(arrayList: List<FeedsTable>) {
        val callbacks = FeedDiffCallbacks(oldArrayList = this.arrayList, newArrayList = arrayList)
        val diff = DiffUtil.calculateDiff(callbacks)
        this.arrayList.clear()
        this.arrayList.addAll(arrayList)
        diff.dispatchUpdatesTo(this)
    }

    private fun getRelativeTime(dateCreated: String): String {
        // "Mon Sep 21 17:22:43 +0000 2020"
        val sf = SimpleDateFormat("EEE MMM dd HH:mm:ss ZZ yyyy", Locale.getDefault())
        val date = sf.parse(dateCreated)

        return if (date != null) {
            DateUtils.getRelativeTimeSpanString(date.time, System.currentTimeMillis(), 0).toString()
                .replace("ago", "")
        } else {
            ""
        }

    }

}