package com.example.globallogicapp.data

import com.example.globallogicapp.data.model.ArticleModel
import com.example.globallogicapp.data.network.ArticleListNetworkDataSource
import javax.inject.Inject

class ArticleListRepository @Inject constructor(private val networkDataSource: ArticleListNetworkDataSource) {

    suspend fun getArticleList(): List<ArticleModel> {

        return networkDataSource.getArticles()
    }
}