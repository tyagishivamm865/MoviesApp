package com.example.ufodemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @Expose
    @SerializedName("data")
    val data: DataX,
    @Expose
    @SerializedName("status")
    val status: String,
    @Expose
    @SerializedName("statusCode")
    val statusCode: String
)