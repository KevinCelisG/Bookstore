package com.example.bookstore.domain

import com.example.bookstore.data.repository.BookstoreRepository
import com.example.bookstore.domain.model.Book
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class GetAllBooksUseCaseTest {

    private lateinit var getAllBooksUseCase: GetAllBooksUseCase

    @MockK
    private lateinit var bookstoreRepository: BookstoreRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        getAllBooksUseCase = GetAllBooksUseCase(bookstoreRepository)
    }

    @Test
    fun whenTheUserDoesNotExist() = runBlocking {
        coEvery { bookstoreRepository.getAllBooks() } returns mutableListOf()

        val result = getAllBooksUseCase.invoke()

        assertEquals(mutableListOf<Book>(), result)
    }
}