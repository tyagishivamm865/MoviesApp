package com.example.ufodemo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ufodemo.MainActivity
import com.example.ufodemo.R
import com.example.ufodemo.ShowAllFragment
import com.example.ufodemo.model.Category
import com.example.ufodemo.model.Content
import kotlinx.android.synthetic.main.itemimage.view.*
import kotlinx.android.synthetic.main.itemrecycler.view.*


class ChannelRecyclerViewAdapter(val context: Context) :

    RecyclerView.Adapter<ChannelRecyclerViewAdapter.ChannelViewHolder>() {
     var channel: List<Category>  = listOf()
    inner class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.movieRecycler)
        val threeDots = itemView.findViewById<ImageView>(R.id.threeDots)
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

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = channel[position]

        holder.itemView.apply {
            textView.text = channel.channelName
            threeDots.setOnClickListener{
                val appCompatActivity = it.context as MainActivity
                Toast.makeText(context,"ShowAllFragment",Toast.LENGTH_SHORT).show()
                val myFragment: Fragment = ShowAllFragment()
                appCompatActivity.supportFragmentManager.beginTransaction()
                    .replace(R.id.framelayout, myFragment).addToBackStack(null)
                    .commit()
            }

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