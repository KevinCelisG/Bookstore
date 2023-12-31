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

    // API client instance for making requests to the Bookstore API.
    private val apiClient = bookstoreClient.getApiClient()

    /**
     * Performs user authentication and get session keys.
     * @param email Email.
     * @param password Password.
     * @return A list containing "o_u" and "sesskey" if authentication is successful, otherwise an empty list.
     */
    suspend fun login(email: String, password: String): List<String> {
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

                        val keyList = mutableListOf<String>()
                        keyList.add(oauthKey.body()!!.o_u)
                        keyList.add(sessionKey.body()!!.sesskey)

                        return@withContext keyList
                    }
                }
            } catch (e: Exception) {
                Log.e(Constants.TAG, e.toString())
            }
            return@withContext emptyList()
        }
    }

    /**
     * Gets a list of books based on user and session information.
     * @param o_u User identifier.
     * @param sesskey Session key for authentication.
     * @return A list of Book objects.
     */
    suspend fun getAllBooks(o_u: String, sesskey: String): List<Book> {
        return withContext(Dispatchers.IO) {
            val booksList = mutableListOf<Book>()
            val books =
                apiClient.getAllBooks(Constants.REQUEST_GET_ALL_BOOKS, o_u, o_u, sesskey).execute()

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