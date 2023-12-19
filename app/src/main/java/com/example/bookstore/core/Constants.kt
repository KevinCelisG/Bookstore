package com.example.bookstore.core

import retrofit2.http.POST

class Constants {
    companion object {
        const val REQUEST_CREATE_SESSION_KEY = "createSesskey"
        const val REQUEST_CREATE_OAUTH_KEY = "createOauthkey"
        const val REQUEST_CREATE_APP_KEY = "createAppkey"
        const val REQUEST_GET_ALL_BOOKS = "getAllBooks"
        const val APP_NAME_PARAMETER = "Bookstore"

        const val BASE_URL_API = "https://timetonic.com"
        const val END_POINT = "/live/api.php"

        const val TAG = "AndroidRuntime"

        const val TOTAL_TIME_SPLASH = 2000L
        const val COUNT_DOWN_TIME_SPLASH = 1000L
    }
}