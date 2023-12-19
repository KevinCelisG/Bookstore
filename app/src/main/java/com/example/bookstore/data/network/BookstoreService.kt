package com.example.bookstore.data.network

import android.util.Log
import com.example.bookstore.core.Constants
import com.example.bookstore.data.model.OauthKey
import com.example.bookstore.data.model.SessionKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookstoreService @Inject constructor(
    bookstoreClient: BookstoreClient
) {

    private val apiClient = bookstoreClient.getApiClient()

    suspend fun login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val appKey = apiClient.createAppKey(Constants.REQUEST_CREATE_APP_KEY, Constants.APP_NAME_PARAMETER).execute()
                if (appKey.isSuccessful) {
                    val oauthKey = apiClient.createOauthKey(Constants.REQUEST_CREATE_OAUTH_KEY, email, password, appKey.body()!!.appkey).execute()
                    if (oauthKey.isSuccessful) {
                        val sessionKey = apiClient.createSessionKey(Constants.REQUEST_CREATE_SESSION_KEY, oauthKey.body()!!.o_u, oauthKey.body()!!.oauthkey).execute()
                        return@withContext sessionKey.isSuccessful
                    }
                }
            } catch (e: Exception) {
                Log.e(Constants.TAG, e.toString())
            }
            return@withContext false
        }
    }
}