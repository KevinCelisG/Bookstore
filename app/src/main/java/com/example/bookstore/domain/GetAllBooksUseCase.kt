package com.example.bookstore.domain

import com.example.bookstore.data.repository.BookstoreRepository
import com.example.bookstore.domain.model.Book
import javax.inject.Inject

class GetAllBooksUseCase @Inject constructor(private val bookstoreRepository: BookstoreRepository) {
    suspend fun invoke(): List<Book> = bookstoreRepository.getAllBooks()

    fun removeKeyList() = bookstoreRepository.removeKeyList()
}