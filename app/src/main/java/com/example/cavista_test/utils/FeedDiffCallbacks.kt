package com.example.cavista_test.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.cavista_test.data.db.FeedsTable

class FeedDiffCallbacks(
    val oldArrayList: ArrayList<FeedsTable>,
    val newArrayList: List<FeedsTable>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldArrayList.size

    override fun getNewListSize() = newArrayList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldArrayList[oldItemPosition].feedId == newArrayList[newItemPosition].feedId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldArrayList[oldItemPosition].feedId == newArrayList[newItemPosition].feedId
}