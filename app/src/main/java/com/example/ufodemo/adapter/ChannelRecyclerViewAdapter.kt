package com.example.ufodemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ufodemo.R
import com.example.ufodemo.model.Category
import com.example.ufodemo.model.Content
import kotlinx.android.synthetic.main.itemimage.view.*
import kotlinx.android.synthetic.main.itemrecycler.view.*

class ChannelRecyclerViewAdapter(val context: Context) :

    RecyclerView.Adapter<ChannelRecyclerViewAdapter.ChannelViewHolder>() {
     var channel: List<Category>  = listOf()
    inner class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.movieRecycler)
        val adapter = MoviesRecyclerViewAdapter(context)
        init {
            recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            recyclerView.adapter = adapter
        }
        fun bindData(movies:List<Content>){
            adapter.setData(movies)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        return ChannelViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itemrecycler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = channel[position]

        holder.itemView.apply {
            textView.text = channel.channelName

        }
        holder.bindData(channel.content)
    }

    override fun getItemCount(): Int {
        return channel.size
    }

    fun setData(channel: List<Category>){
        this.channel = channel
        notifyDataSetChanged()
    }
}