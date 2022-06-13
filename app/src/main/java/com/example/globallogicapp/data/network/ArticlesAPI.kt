package com.example.globallogicapp.data.network

import com.example.globallogicapp.data.model.ArticleModel
import retrofit2.Response
import retrofit2.http.GET

interface ArticlesAPI {
    @GET("list")
    suspend fun getArticles(): Response<List<ArticleModel>>
}