package com.example.bookstore.data.model

data class AllBooks(val allBooks: Books)

data class Books(val books: List<Book>)

data class Book(val ownerPrefs: Prefs)

data class Prefs(val oCoverImg: String, val title: String)