package com.example.bookstore.domain.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.domain.model.Book


class BookAdapter(private val booksList : List<Book>) : RecyclerView.Adapter<BookViewHolder>(){

    /**
     * Inflates the layout for individual book items and creates a corresponding ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BookViewHolder(layoutInflater.inflate(R.layout.book_item, parent, false))
    }

    /**
     * Returns the total number of items in the list.
     */
    override fun getItemCount() = booksList.size

    /**
     * Binds the data at the specified position to the ViewHolder.
     * @param holder The ViewHolder to bind the data.
     * @param position The position of the item in the list.
     */
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = booksList[position]
        holder.render(item)
    }
}