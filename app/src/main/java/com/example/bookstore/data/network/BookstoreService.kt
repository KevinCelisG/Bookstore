package com.example.bookstore.data.network

import android.util.Log
import com.example.bookstore.core.Constants
import com.example.bookstore.domain.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookstoreService @Inject constructor(
    bookstoreClient: BookstoreClient
) {

    private val apiClient = bookstoreClient.getApiClient()
    private lateinit var sesskey: String
    private lateinit var o_u: String

    suspend fun login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val appKey = apiClient.createAppKey(
                    Constants.REQUEST_CREATE_APP_KEY,
                    Constants.APP_NAME_PARAMETER
                ).execute()
                if (appKey.isSuccessful) {
                    val oauthKey = apiClient.createOauthKey(
                        Constants.REQUEST_CREATE_OAUTH_KEY,
                        email,
                        password,
                        appKey.body()!!.appkey
                    ).execute()
                    if (oauthKey.isSuccessful) {
                        val sessionKey = apiClient.createSessionKey(
                            Constants.REQUEST_CREATE_SESSION_KEY,
                            oauthKey.body()!!.o_u,
                            oauthKey.body()!!.oauthkey
                        ).execute()

                        o_u = oauthKey.body()!!.o_u
                        sesskey = sessionKey.body()!!.sesskey

                        return@withContext sessionKey.isSuccessful
                    }
                }
            } catch (e: Exception) {
                Log.e(Constants.TAG, e.toString())
            }
            return@withContext false
        }
    }

    suspend fun getAllBooks(): List<Book> {
        return withContext(Dispatchers.IO) {
            val booksList = mutableListOf<Book>()
            val books = apiClient.getAllBooks(Constants.REQUEST_GET_ALL_BOOKS, o_u, o_u, sesskey).execute()

            for (book in books.body()!!.allBooks.books) {
                booksList.add(
                    Book(
                        book.ownerPrefs.title,
                        "${Constants.BASE_URL_API}${book.ownerPrefs.oCoverImg}"
                    )
                )
            }

            return@withContext booksList
        }
    }
}