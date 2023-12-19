package com.example.bookstore.data.repository

import android.util.Log
import com.example.bookstore.core.Constants
import com.example.bookstore.data.local.SharedPreferencesService
import com.example.bookstore.data.network.BookstoreService
import com.example.bookstore.domain.model.Book
import javax.inject.Inject

class BookstoreRepository @Inject constructor(
    private val bookstoreService: BookstoreService,
    private val sharedPreferencesService: SharedPreferencesService
) {
    suspend fun login(email: String, password: String): Boolean {
        val keyList = bookstoreService.login(email, password)

        return if (!keyList[0].isNullOrEmpty() || !keyList[1].isNullOrEmpty()) {
            sharedPreferencesService.saveKeyList(keyList)
            true
        } else {
            false
        }
    }

    suspend fun getAllBooks(): List<Book> {
        val keyList = sharedPreferencesService.getKeyList()
        return bookstoreService.getAllBooks(keyList[0], keyList[1])
    }

    fun isKeyListSaved(): Boolean = sharedPreferencesService.getKeyList().isNotEmpty()

    fun removeKeyList() = sharedPreferencesService.removeKeyList()
}