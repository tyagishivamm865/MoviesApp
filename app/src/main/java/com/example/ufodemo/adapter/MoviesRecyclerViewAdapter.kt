package com.example.ufodemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ufodemo.R
import com.example.ufodemo.model.Content
import kotlinx.android.synthetic.main.itemimage.view.*


class MoviesRecyclerViewAdapter(val context: Context) :
    RecyclerView.Adapter<MoviesRecyclerViewAdapter.MoviesViewHolder>() {
    var movies: List<Content> = listOf()

    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itemimage, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = movies[position]

        holder.itemView.apply {
            Glide.with(this).load(movies.imagePath).into(movie_image)
            movie_name.text = movies.contentName
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData(movies: List<Content>) {
        this.movies = movies
        notifyDataSetChanged()
    }

}