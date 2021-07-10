package com.example.bukuapp.util

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bukuapp.R
import com.example.bukuapp.model.Author
import com.squareup.picasso.Picasso

class AuthorAdapter : RecyclerView.Adapter<AuthorAdapter.AuthorHolder>() {

    var listData = listOf<Author>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class AuthorHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.cardView)
        val name = itemView.findViewById<TextView>(R.id.name)
        val cover = itemView.findViewById<ImageView>(R.id.imageView)
        val bookSum = itemView.findViewById<TextView>(R.id.book_sum)

        fun image(url : String){
            Picasso.get()
                    .load(url)
                    .resize(400, 400)
                    .centerCrop()
                    .into(cover)
        }

        fun bind(author: Author){
            name.text = author.name
            image(author.urlCover)
            bookSum.text = "${author.book} buku"
            cardView.setOnClickListener { it ->
                it.findNavController().navigate(R.id.action_homeFragment_to_authorDetailFragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.author_item, parent, false)
        return AuthorHolder(view)
    }

    override fun onBindViewHolder(holder: AuthorHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)

        //int to dp
        fun Int.toPx() : Int = (this * Resources.getSystem().displayMetrics.density).toInt()

        if(position == listData.lastIndex){
            val params = holder.cardView.layoutParams as ConstraintLayout.LayoutParams
            params.marginEnd = 20.toPx()
            holder.cardView.layoutParams = params
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}