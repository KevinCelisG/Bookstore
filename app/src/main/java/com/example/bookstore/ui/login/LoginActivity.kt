package com.example.bookstore.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.bookstore.R
import com.example.bookstore.core.Util
import com.example.bookstore.databinding.ActivityLoginBinding
import com.example.bookstore.ui.landing.LandingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    // View binding for the activity layout.
    private lateinit var binding: ActivityLoginBinding

    // ViewModel for managing data and business logic related to login.
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isKeyListSaved()
        binding.buttonLogin.setOnClickListener { lifecycleScope.launch { login() } }
    }

    /**
     * Checks if session keys are saved, and if yes, redirects to the landing page.
     */
    private fun isKeyListSaved() {
        if (loginViewModel.isKeyListSaved()) {
            val intent = Intent(this@LoginActivity, LandingActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * Asynchronously performs user login and handles UI updates based on the result.
     */
    private suspend fun login() {
        if (checkFields()) {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            binding.progressBar.visibility = View.VISIBLE

            if (loginViewModel.login(email, password)) {
                Util.showAShortMessage(this, R.string.authentication_successful)
                val intent = Intent(this@LoginActivity, LandingActivity::class.java)
                startActivity(intent)
                clearFields()
            } else {
                Util.showAShortMessage(this, R.string.authentication_error)
            }

            binding.progressBar.visibility = View.INVISIBLE
        } else {
            Util.showAShortMessage(this, R.string.fields_error)
        }
    }

    /**
     * Clears input fields for email and password.
     */
    private fun clearFields() {
        binding.editTextEmail.text.clear()
        binding.editTextPassword.text.clear()
    }

    /**
     * Checks if input fields for email and password are not empty.
     */
    private fun checkFields(): Boolean =
        binding.editTextEmail.text.isNotEmpty() and binding.editTextPassword.text.isNotEmpty()
}