package com.example.bookstore.domain.adapter

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.bookstore.databinding.BookItemBinding
import com.example.bookstore.domain.model.Book

class BookViewHolder(view: View) : ViewHolder(view) {

    // Binding object for accessing views within the item layout.
    private val binding = BookItemBinding.bind(view)

    /**
     * Renders book information by updating the views in the item layout.
     * @param book The Book object containing information to be displayed.
     */
    fun render(book: Book) {
        binding.textViewTitle.text = book.title
        Glide.with(binding.imageViewImage.context).load(book.image).into(binding.imageViewImage)
    }
}