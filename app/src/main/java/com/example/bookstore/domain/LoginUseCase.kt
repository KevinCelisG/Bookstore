package com.example.bookstore.domain

import com.example.bookstore.data.repository.BookstoreRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val bookstoreRepository: BookstoreRepository) {
    suspend fun invoke(email: String, password: String): Boolean =
        bookstoreRepository.login(email, password)

    fun isKeyListSaved(): Boolean = bookstoreRepository.isKeyListSaved()
}