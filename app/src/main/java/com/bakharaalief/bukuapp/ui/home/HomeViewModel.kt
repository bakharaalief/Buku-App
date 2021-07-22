package com.bakharaalief.bukuapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bakharaalief.bukuapp.data.model.Author
import com.bakharaalief.bukuapp.data.model.Book

class HomeViewModel : ViewModel() {

    private val _listBook : MutableLiveData<List<Book>> = MutableLiveData<List<Book>>()
    val listBook : LiveData<List<Book>> = _listBook

    private val _listAuthor : MutableLiveData<List<Author>> = MutableLiveData<List<Author>>()
    val listAuthor : LiveData<List<Author>> = _listAuthor

    init {
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

        //list auhtor
        val listAuthor = ArrayList<Author>()
        listAuthor.add(
                Author(
                        "Rintik Sedu",
                        "https://awsimages.detik.net.id/community/media/visual/2020/02/27/9d5daf40-299f-4a02-91f2-39a2f81981de_43.jpeg?w=700&q=90",
                        10
                )
        )
        listAuthor.add(
                Author(
                        "Tere Liye",
                        "https://awsimages.detik.net.id/community/media/visual/2018/04/08/e8b098b9-19f2-45ea-868b-4e478ff6c5e6_169.jpeg?w=700&q=90",
                        10
                )
        )
        listAuthor.add(
                Author(
                        "Andrea Hirata",
                        "https://4.bp.blogspot.com/-aefSkdnWy5M/Wq8t_k4ETOI/AAAAAAAAACE/LDZSvLkaCUYo-i63dk1IrPRNWJiSdnCygCLcBGAs/s1600/Andrea%2BHirata.jpg",
                        10
                )
        )
        listAuthor.add(
                Author(
                        "A. Fuadi",
                        "https://lh3.googleusercontent.com/proxy/Jt9WXKUpmlwKOh-uduElXd12NtY2_QzqqUtP1zT8BPLWXb7owjdv0_H_qYSOs2Zq3Xtk282m8uMEHi-wgqT__DfdSzjjoYgYh-sPK8apEJAEjYdRglbg1onrp7qMdQ_lfS375tcPeSs",
                        10
                )
        )

        //list book
        _listBook.value = listBook
        _listAuthor.value = listAuthor
    }
}