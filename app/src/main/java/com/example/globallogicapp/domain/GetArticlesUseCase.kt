package com.example.globallogicapp.domain

import com.example.globallogicapp.data.ArticleListRepository
import com.example.globallogicapp.data.model.ArticleModel
import javax.inject.Inject


class GetArticlesUseCase @Inject constructor(private val repository: ArticleListRepository) {

    suspend operator fun invoke(): List<ArticleModel> = repository.getArticleList()

}