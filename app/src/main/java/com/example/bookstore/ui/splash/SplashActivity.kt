package com.example.bookstore.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.bookstore.R
import com.example.bookstore.core.Constants
import com.example.bookstore.databinding.ActivityMainBinding
import com.example.bookstore.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

class SplashActivity : AppCompatActivity() {

    // View binding for the activity layout.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startCountDown()
    }

    /**
     * Initiates a countdown timer to control the duration of the splash screen.
     * Upon completion, navigates to the login screen and finishes the activity.
     */
    private fun startCountDown() {
        object : CountDownTimer(Constants.TOTAL_TIME_SPLASH, Constants.COUNT_DOWN_TIME_SPLASH) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}