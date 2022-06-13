package com.example.globallogicapp.data.database

import com.example.globallogicapp.data.model.ArticleModel

class ArticleListLocalDataSource {
    companion object{
        var articlesList: List<ArticleModel> = emptyList()
    }
}