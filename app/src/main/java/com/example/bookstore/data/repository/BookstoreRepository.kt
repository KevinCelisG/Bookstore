package com.example.bookstore.data.repository

import com.example.bookstore.data.network.BookstoreService
import com.example.bookstore.domain.model.Book
import javax.inject.Inject

class BookstoreRepository @Inject constructor(private val bookstoreService: BookstoreService) {
    suspend fun login(email: String, password: String): Boolean =
        bookstoreService.login(email, password)

    suspend fun getAllBooks(): List<Book> = bookstoreService.getAllBooks()
}