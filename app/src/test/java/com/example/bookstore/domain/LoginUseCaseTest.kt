package com.example.bookstore.domain

import com.example.bookstore.data.repository.BookstoreRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class LoginUseCaseTest {

    private val emailTest = "android.developer@timetonic.com"
    private val passwordTest = "Android.developer1"

    private lateinit var loginUseCase: LoginUseCase

    @MockK
    private lateinit var bookstoreRepository: BookstoreRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        loginUseCase = LoginUseCase(bookstoreRepository)
    }

    @Test
    fun whenTheUserDoesNotExist() = runBlocking {
        coEvery { bookstoreRepository.login(emailTest, passwordTest) } returns true

        val result = loginUseCase.invoke(emailTest, passwordTest)

        Assert.assertEquals(true, result)
    }
}