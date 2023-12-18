package com.example.bookstore.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookstore.R
import com.example.bookstore.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener { login() }
    }

    private fun login() {}
}