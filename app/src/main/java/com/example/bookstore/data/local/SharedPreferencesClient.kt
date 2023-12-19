package com.example.bookstore.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesClient @Inject constructor(@ApplicationContext context: Context) {

    // Shared Preferences instance for managing user preferences.
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

    // SharedPreferences editor for making changes to preferences.
    val editor: SharedPreferences.Editor = sharedPreferences.edit()
}