package com.example.cavista_test.data

import com.example.cavista_test.data.db.DbHelper
import com.example.cavista_test.data.network.ApiHelper
import com.example.cavista_test.data.prefs.PrefsHelper

interface DataManager : ApiHelper, DbHelper, PrefsHelper{
    fun onSignOutClicked()
}