package com.example.bookstore.data.network

import android.util.Log
import com.example.bookstore.core.Constants
import com.example.bookstore.data.model.AllBooks
import com.example.bookstore.data.model.AppKey
import com.example.bookstore.data.model.Books
import com.example.bookstore.data.model.OauthKey
import com.example.bookstore.data.model.SessionKey
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BookstoreApiClient {

    /**
     * Creates an application key for the specified app name.
     */
    @FormUrlEncoded
    @POST(Constants.END_POINT)
    fun createAppKey(
        @Field("req") req: String,
        @Field("appname") appName: String
    ): Call<AppKey>

    /**
     * Creates an OAuth key for user authentication.
     */
    @FormUrlEncoded
    @POST(Constants.END_POINT)
    fun createOauthKey(
        @Field("req") req: String,
        @Field("login") email: String,
        @Field("pwd") password: String,
        @Field("appkey") appKey: String
    ): Call<OauthKey>

    /**
     * Creates a session key for user session management.
     */
    @FormUrlEncoded
    @POST(Constants.END_POINT)
    fun createSessionKey(
        @Field("req") req: String,
        @Field("o_u") o_u: String,
        @Field("oauthkey") oauthKey: String
    ): Call<SessionKey>

    /**
     * Gets a list of books based on user and session information.
     */
    @FormUrlEncoded
    @POST(Constants.END_POINT)
    fun getAllBooks(
        @Field("req") req: String,
        @Field("o_u") o_u: String,
        @Field("u_c") u_c: String,
        @Field("sesskey") sessionKey: String
    ): Call<AllBooks>
}