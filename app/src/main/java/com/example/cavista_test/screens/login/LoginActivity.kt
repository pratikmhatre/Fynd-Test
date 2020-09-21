package com.example.cavista_test.screens.login

import android.content.Intent
import android.os.Bundle
import com.example.cavista_test.databinding.ActivityLoginBinding
import com.example.cavista_test.screens.feed.FeedActivity
import com.example.cavista_test.utils.BaseActivity
import com.google.firebase.auth.FirebaseAuth
import com.twitter.sdk.android.core.Callback
import com.twitter.sdk.android.core.Result
import com.twitter.sdk.android.core.TwitterException
import com.twitter.sdk.android.core.TwitterSession
import javax.inject.Inject

class LoginActivity : BaseActivity() {
    private lateinit var auth: FirebaseAuth

    @Inject
    lateinit var loginViewModel: LoginViewModel

    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        auth = FirebaseAuth.getInstance();
        activityComponent.inject(this)



        loginBinding.btnLogin.callback = object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>?) {
                showToast(msg = "success")
                result?.data?.run {
                    loginViewModel.saveCredentials(
                        this.userId.toString(),
                        this.userName,
                        this.authToken.token, this.authToken.secret
                    )


                    loginViewModel.clearFeeds()
                    startActivity(Intent(this@LoginActivity, FeedActivity::class.java))
                    finish()
                }

            }


            override fun failure(exception: TwitterException?) {
                showToast(msg = "failure")
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loginBinding.btnLogin.onActivityResult(requestCode, resultCode, data)
    }
}