package com.example.ufodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ufodemo.adapter.ChannelRecyclerViewAdapter
import com.example.ufodemo.model.Category
import com.example.ufodemo.model.Data
import com.example.ufodemo.model.UserInfo
import com.example.ufodemo.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MovieViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var channelAdapter: ChannelRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
initViewModel()
    createUser()
        recyclerView = findViewById(R.id.parentrecycler1)
recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        channelAdapter = ChannelRecyclerViewAdapter(this)
        recyclerView.adapter = channelAdapter

//        val dataRepo = MovieRepository()
//        viewModel =
//            ViewModelProvider(this, MovieViewModelFactory(dataRepo)).get(MovieViewModel::class.java)
//
//    val tid= UserInfo(59274)
//
//    viewModel.findUser1(tid)
//    viewModel.userData.observe(this, Observer { response ->
//        Log.d("response", response.message.toString())
//        when (response) {
//            is Resource.Success -> {
//
//                response.data?.let { userResponse ->
//                    Log.d("success","response.message.toString()")
//                }
//            }
//            is Resource.Error -> {
//
//                response.message?.let {
//                    Log.e("usermessage", "An error occured:$it")
//                }
//            }
//
//            else -> {
//                Log.e("loading", "Loading heavily")
//            }
//        }
//
//    })
//
  }

    private fun createUser() {
        val user=UserInfo(59274)
        viewModel.createUser(user)
    }
    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.findUser1().observe(this, Observer<Data?> {
            if(it==null){
                Log.d("fail","failed")
            }
            else{
                Log.d("success","Success")
                channelAdapter.setData(it.data.categories)

            }
        })
    }
}

