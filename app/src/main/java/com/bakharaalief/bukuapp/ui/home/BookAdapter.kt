package com.bakharaalief.bukuapp.ui.home

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
import com.bakharaalief.bukuapp.R
import com.bakharaalief.bukuapp.data.model.Book
import com.bakharaalief.bukuapp.ui.bookDetail.BookDetailFragmentDirections
import com.squareup.picasso.Picasso


val HOME_FRAGMENT = "home_fragment"
val BOOK_DETAIL_FRAGMENT = "book_detail_fragment"

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookHolder>() {


    var listData = listOf<Book>()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    var origin = ""
    set(value){
        field = value
    }

    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.cardView)
        val cover = itemView.findViewById<ImageView>(R.id.imageView)
        val title = itemView.findViewById<TextView>(R.id.name)
        val author = itemView.findViewById<TextView>(R.id.author)

        fun image(url : String){
            Picasso.get()
                .load(url)
                .fit()
                .into(cover)
        }

        fun bind(book: Book, origin : String){
            title.text = book.title
            author.text = book.author
            image(book.urlCover)

            cardView.setOnClickListener { it ->
                if(origin == HOME_FRAGMENT){
                    val action = HomeFragmentDirections.actionHomeFragmentToBookDetailFragment(book)
                    it.findNavController().navigate(action)
                }
                else if(origin == BOOK_DETAIL_FRAGMENT){
                    val action = BookDetailFragmentDirections.actionBookDetailFragmentSelf(book)
                    it.findNavController().navigate(action)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.book_item, parent, false)
        return BookHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bind(listData[position], origin)

        //int to dp
        fun Int.toPx() : Int = (this * Resources.getSystem().displayMetrics.density).toInt()

        if(position == listData.lastIndex){
            //last index with end 20 margin end
            val params = holder.cardView.layoutParams as ConstraintLayout.LayoutParams
            params.marginEnd = 20.toPx()
            holder.cardView.layoutParams = params
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}