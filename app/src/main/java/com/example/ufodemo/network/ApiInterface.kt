package com.example.ufodemo.network

import com.example.ufodemo.model.Data
import com.example.ufodemo.model.UserInfo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit


interface ApiInterface {


    @Headers("content-Type:application/json", "X-API-Key:03a53461dfdf11ea85d10a5cd31394da")
    @POST(".")
    fun findUser(@Body userData: UserInfo): Call<Data>

    companion object {
        val BASE_URL = "https://userqaapi.plexigo.com/api/content/ChannelWiseContentlisting/"
        fun getRetroInstance(): Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)
                .connectTimeout(100, TimeUnit.SECONDS) // connect timeout
                .writeTimeout(100, TimeUnit.SECONDS) // write timeout
                .readTimeout(100, TimeUnit.SECONDS)
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}

