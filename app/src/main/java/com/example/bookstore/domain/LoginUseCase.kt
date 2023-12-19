package com.example.bookstore.domain

import com.example.bookstore.data.repository.BookstoreRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val bookstoreRepository: BookstoreRepository) {

    /**
     * Asynchronously invokes the use case to perform user login.
     * @param email Email.
     * @param password Password.
     * @return `true` if login is successful, `false` otherwise.
     */
    suspend fun invoke(email: String, password: String): Boolean =
        bookstoreRepository.login(email, password)

    /**
     * Checks if session keys are saved.
     * @return `true` if session keys are saved, `false` otherwise.
     */
    fun isKeyListSaved(): Boolean = bookstoreRepository.isKeyListSaved()
}