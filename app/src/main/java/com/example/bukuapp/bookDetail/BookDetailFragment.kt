package com.example.bukuapp.bookDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bukuapp.databinding.BookDetailFragmentBinding
import com.example.bukuapp.util.BOOK_DETAIL_FRAGMENT
import com.example.bukuapp.util.BookAdapter
import com.squareup.picasso.Picasso

class BookDetailFragment : Fragment() {

    private lateinit var viewModel: BookDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = BookDetailFragmentBinding.inflate(inflater, container, false)

        //view model
        val viewModelFactory = BookDetailFactory(BookDetailFragmentArgs.fromBundle(requireArguments()).bookData)
        viewModel = ViewModelProvider(this, viewModelFactory).get(BookDetailViewModel::class.java)

        val adapter = BookAdapter()
        adapter.origin = BOOK_DETAIL_FRAGMENT
        viewModel.recommendationList.observe(viewLifecycleOwner, Observer { it ->
            adapter.listData = it
        })

        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.bukuLainnyaRv.layoutManager = linearLayoutManager
        binding.bukuLainnyaRv.adapter = adapter

        //new data from args
        viewModel.bookData.observe(viewLifecycleOwner, Observer {
            binding.titleInCollapsed.text = it.title
            binding.authorInCollapsed.text = it.author
            callImage(it.urlCover, binding.imageView)
        })

        return binding.root
    }

    fun callImage(url : String, imageView: ImageView){
        Picasso.get()
            .load(url)
            .fit()
            .into(imageView)
    }
}