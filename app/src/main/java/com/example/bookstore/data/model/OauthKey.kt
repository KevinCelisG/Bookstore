package com.example.bookstore.data.model

/**
 * Data class representing an OAuth key associated with a user.
 * @property o_u The "o_u" identifier associated with the user.
 * @property oauthkey The OAuth key for authentication.
 */
data class OauthKey(val o_u: String, val oauthkey: String)