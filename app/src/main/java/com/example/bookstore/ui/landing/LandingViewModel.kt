package com.example.bookstore.ui.landing

import androidx.lifecycle.ViewModel
import com.example.bookstore.domain.GetAllBooksUseCase
import com.example.bookstore.domain.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(private val getAllBooksUseCase: GetAllBooksUseCase) :
    ViewModel() {
    suspend fun getAllBooks(): List<Book> = getAllBooksUseCase.invoke()

    fun removeKeyList() = getAllBooksUseCase.removeKeyList()
}