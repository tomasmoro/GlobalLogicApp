package com.example.globallogicapp.data.model

import com.google.gson.annotations.SerializedName

data class ArticleModel(
    @SerializedName("title") val title: String = "",
    @SerializedName("description") val description: String = "",
    @SerializedName("image") val thumbnail: String = ""
)
