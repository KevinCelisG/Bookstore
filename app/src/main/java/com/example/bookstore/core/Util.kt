package com.example.bookstore.core

import android.content.Context
import android.widget.Toast

class Util {

    companion object {
        /**
         * Displays a short Toast message using the provided context and string resource ID.
         * @param context The context in which the Toast message will be displayed.
         * @param stringId The resource ID of the string to be shown in the Toast message.
         */
        fun showAShortMessage(context: Context, stringId: Int) =
            Toast.makeText(context, stringId, Toast.LENGTH_SHORT).show()
    }
}