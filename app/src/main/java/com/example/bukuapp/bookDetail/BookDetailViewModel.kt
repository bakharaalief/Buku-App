package com.example.bukuapp.bookDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bukuapp.model.Book

class BookDetailViewModel(book: Book) : ViewModel() {

    private val _recommendationList : MutableLiveData<List<Book>> = MutableLiveData<List<Book>>()
    val recommendationList : LiveData<List<Book>> = _recommendationList

    private val _bookData : MutableLiveData<Book> = MutableLiveData<Book>()
    val bookData : LiveData<Book> = _bookData

    init {
        //new value
        _bookData.value = book

        //list book
        val listBook = ArrayList<Book>()
        listBook.add(
                Book(
                        "Kata",
                        "https://www.bukukita.com/babacms/displaybuku/109796_f.jpg",
                        "Rintik Sedu"
                )
        )
        listBook.add(
                Book(
                        "Bumi",
                        "https://www.bukukita.com/babacms/displaybuku/95219_f.jpg",
                        "Tere Liye"
                )
        )
        listBook.add(
                Book(
                        "Laut Bercerita",
                        "https://ebooks.gramedia.com/ebook-covers/40678/big_covers/ID_KPG2017MTH10LBER_B.jpg",
                        "Leila S. C."
                )
        )
        listBook.add(
                Book(
                        "Bulan",
                        "https://www.bukukita.com/babacms/displaybuku/95221_f.jpg",
                        "Tere Liye"
                )
        )

        _recommendationList.value = listBook
    }


}