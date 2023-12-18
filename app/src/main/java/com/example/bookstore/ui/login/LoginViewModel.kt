package com.example.bookstore.ui.login

import androidx.lifecycle.ViewModel
import com.example.bookstore.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    suspend fun login(email: String, password: String): Boolean =
        loginUseCase.invoke(email, password)
}