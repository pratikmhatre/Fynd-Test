package com.example.cavista_test.data.network.responses

import com.google.gson.annotations.SerializedName

class FeedPojo {
    var id: Long = 0
    var text: String? = null
    var user: User? = null

    @SerializedName("favorite_count")
    var fevrtCount:String?=null

    @SerializedName("retweet_count")
    var retweetCount:String?=null

    @SerializedName("retweeted_status")
    var retweetedStatus : RetweetedStatus?=null

    @SerializedName("created_at")
    var createdAt: String? = null

    inner class User {
        @SerializedName("profile_image_url_https")
        var profileImage: String? = null

        @SerializedName("id_str")
        var id: String? = null

        var name: String? = null

        @SerializedName("screen_name")
        var screenName: String? = null


    }

    inner class RetweetedStatus {
        var user: User? = null
    }
}
