package com.example.bukuapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bukuapp.databinding.FragmentHomeBinding
import com.example.bukuapp.util.AuthorAdapter
import com.example.bukuapp.util.BookAdapter
import com.example.bukuapp.util.HOME_FRAGMENT

class HomeFragment : Fragment() {

    private lateinit var viewModel : HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        //view model
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        //book rv
        val adapter = BookAdapter()
        adapter.origin = HOME_FRAGMENT
        viewModel.listBook.observe(viewLifecycleOwner, Observer { it ->
            adapter.listData = it
        })

        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.bookRv.layoutManager = linearLayoutManager
        binding.bookRv.adapter = adapter

        //author rv
        val adapter2 = AuthorAdapter()

        viewModel.listAuthor.observe(viewLifecycleOwner, Observer { it ->
            adapter2.listData = it
        })

        val linearLayoutManager2 = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.authorRv.layoutManager = linearLayoutManager2
        binding.authorRv.adapter = adapter2

        // Inflate the layout for this fragment
        return binding.root
    }

}