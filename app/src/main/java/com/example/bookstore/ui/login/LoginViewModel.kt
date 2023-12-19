package com.example.bookstore.ui.login

import androidx.lifecycle.ViewModel
import com.example.bookstore.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    /**
     * Asynchronously invokes the use case to perform user login.
     * @param email Email.
     * @param password Password.
     * @return `true` if login is successful, `false` otherwise.
     */
    suspend fun login(email: String, password: String): Boolean =
        loginUseCase.invoke(email, password)

    /**
     * Checks if session keys are saved.
     * @return `true` if session keys are saved, `false` otherwise.
     */
    fun isKeyListSaved(): Boolean = loginUseCase.isKeyListSaved()
}