package com.example.ufodemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserInfo(

    @Expose
    @SerializedName("UserId")
    val UserId:Int

)
