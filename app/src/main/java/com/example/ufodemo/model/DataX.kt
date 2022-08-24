package com.example.ufodemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataX(
    @Expose
    @SerializedName("categories")
    val categories: List<Category>,
    @Expose
    @SerializedName("message")
    val message: Any
)