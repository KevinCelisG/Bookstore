package com.example.bookstore.data.network

import com.example.bookstore.core.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookstoreClient @Inject constructor() {

    private fun getRetrofit(): Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL_API)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getApiClient(): BookstoreApiClient = getRetrofit().create(BookstoreApiClient::class.java)
}