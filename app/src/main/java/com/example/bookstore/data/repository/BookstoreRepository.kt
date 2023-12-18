package com.example.bookstore.data.repository

import com.example.bookstore.data.network.BookstoreService
import javax.inject.Inject

class BookstoreRepository @Inject constructor(private val bookstoreService: BookstoreService) {
    suspend fun login(email: String, password: String) {
        bookstoreService.login(email, password)
    }
}