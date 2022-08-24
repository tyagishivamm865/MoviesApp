package com.example.ufodemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ufodemo.model.Category
import com.example.ufodemo.model.Data
import com.example.ufodemo.model.UserInfo
import com.example.ufodemo.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(): ViewModel() {
    val userData: MutableLiveData<Data?> = MutableLiveData()

    fun findUser1():MutableLiveData<Data?>{
return userData
    }


    fun createUser(uid:UserInfo){
        val retroservice = ApiInterface.getRetroInstance().create(ApiInterface::class.java)
        val call = retroservice.findUser(uid)
        call.enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                if (response.isSuccessful){
                    userData.postValue(response.body())
                }
                else{
                    userData.postValue(null)
                }
            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
                userData.postValue(null)
            }
        })
    }




}