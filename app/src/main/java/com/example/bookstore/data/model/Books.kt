package com.example.bookstore.data.model

/**
 * Data class representing a collection of books.
 * @property allBooks The container for a list of books.
 */
data class AllBooks(val allBooks: Books)

/**
 * Data class representing a list of books.
 * @property books The list of books.
 */
data class Books(val books: List<Book>)

/**
 * Data class representing a book.
 * @property ownerPrefs The preferences of the book owner.
 */
data class Book(val ownerPrefs: Prefs)

/**
 * Data class representing preferences associated with a book owner.
 * @property oCoverImg The cover image for the book.
 * @property title The title for the book.
 */
data class Prefs(val oCoverImg: String, val title: String)