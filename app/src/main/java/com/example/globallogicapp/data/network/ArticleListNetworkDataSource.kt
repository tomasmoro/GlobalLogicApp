package com.example.globallogicapp.data.network

import android.util.Log
import com.example.globallogicapp.data.model.ArticleModel
import com.example.globallogicapp.di.NetworkModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleListNetworkDataSource @Inject constructor(
    private val api: ArticlesAPI
) {
    suspend fun getArticles() : List<ArticleModel> {
        return withContext(Dispatchers.IO){

            val response = api.getArticles()
            response.body() ?: emptyList()
        }
    }
}