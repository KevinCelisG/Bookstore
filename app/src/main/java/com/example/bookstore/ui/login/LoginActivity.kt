package com.example.bookstore.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.bookstore.R
import com.example.bookstore.core.Constants
import com.example.bookstore.core.Util
import com.example.bookstore.databinding.ActivityLoginBinding
import com.example.bookstore.ui.landing.LandingActivity
import com.example.bookstore.ui.splash.SplashActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener { lifecycleScope.launch { login() } }
    }

    private suspend fun login() {
        if (checkFields()) {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val emailTest = "android.developer@timetonic.com"
            val passwordTest = "Android.developer1"

            binding.progressBar.visibility = View.VISIBLE

            if (loginViewModel.login(emailTest, passwordTest)) {
                val intent = Intent(this@LoginActivity, LandingActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Util.showAShortMessage(this, R.string.authentication_error)
            }

            binding.progressBar.visibility = View.INVISIBLE
        } else {
            Util.showAShortMessage(this, R.string.fields_error)
        }
    }

    private fun checkFields(): Boolean =
        binding.editTextEmail.text.isNotEmpty() and binding.editTextPassword.text.isNotEmpty()
}