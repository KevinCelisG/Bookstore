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

    /**
     * Performs user login, saves the session keys if successful, and returns the login status.
     * @param email Email.
     * @param password Password.
     * @return `true` if login is successful, `false` otherwise.
     */
    suspend fun login(email: String, password: String): Boolean {
        val keyList = bookstoreService.login(email, password)

        return if (!keyList[0].isNullOrEmpty() || !keyList[1].isNullOrEmpty()) {
            sharedPreferencesService.saveKeyList(keyList)
            true
        } else {
            false
        }
    }

    /**
     * Gets a list of books using stored session keys.
     * @return A list of Book objects.
     */
    suspend fun getAllBooks(): List<Book> {
        val keyList = sharedPreferencesService.getKeyList()
        return bookstoreService.getAllBooks(keyList[0], keyList[1])
    }

    /**
     * Checks if session keys are saved in SharedPreferences.
     * @return `true` if session keys are saved, `false` otherwise.
     */
    fun isKeyListSaved(): Boolean = sharedPreferencesService.getKeyList().isNotEmpty()

    /**
     * Removes the stored session keys from SharedPreferences.
     */
    fun removeKeyList() = sharedPreferencesService.removeKeyList()
}