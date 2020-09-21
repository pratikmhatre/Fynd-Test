package com.example.cavista_test.utils

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cavista_test.application.MyApplication
import com.example.cavista_test.di.components.ActivityComponent
import com.example.cavista_test.di.components.DaggerActivityComponent
import com.example.cavista_test.di.modules.ActivityModule

abstract class BaseActivity : AppCompatActivity() {
    lateinit var activityComponent: ActivityComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
            .appComponent((application as MyApplication).getAppComponent()).activityModule(
                ActivityModule(this)
            ).build()
    }

    fun showToast(msg: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, msg, length).show()
    }
}