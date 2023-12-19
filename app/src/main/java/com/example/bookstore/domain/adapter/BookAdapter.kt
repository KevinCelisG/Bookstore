package com.example.bookstore.domain.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.domain.model.Book


class BookAdapter(private val booksList : List<Book>) : RecyclerView.Adapter<BookViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BookViewHolder(layoutInflater.inflate(R.layout.book_item, parent, false))
    }

    override fun getItemCount() = booksList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = booksList[position]
        holder.render(item)
    }
}