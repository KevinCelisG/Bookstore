package com.example.bookstore.domain

import com.example.bookstore.data.repository.BookstoreRepository
import com.example.bookstore.domain.model.Book
import javax.inject.Inject

class GetAllBooksUseCase @Inject constructor(private val bookstoreRepository: BookstoreRepository) {

    /**
     * Asynchronously invokes the use case to get a list of books.
     * @return A list of Book objects.
     */
    suspend fun invoke(): List<Book> = bookstoreRepository.getAllBooks()

    /**
     * Removes the stored session keys.
     */
    fun removeKeyList() = bookstoreRepository.removeKeyList()
}