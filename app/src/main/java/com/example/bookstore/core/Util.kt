package com.example.bookstore.core

import android.content.Context
import android.widget.Toast

class Util {
    companion object {
        fun showAShortMessage(context: Context, stringId: Int) =
            Toast.makeText(context, stringId, Toast.LENGTH_SHORT).show()
    }
}