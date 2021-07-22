package com.bakharaalief.bukuapp.ui.bookDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bakharaalief.bukuapp.data.model.Book

class BookDetailFactory(private val book: Book) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookDetailViewModel::class.java)) {
            return BookDetailViewModel(book) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}