package com.example.globallogicapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globallogicapp.data.model.ArticleModel
import com.example.globallogicapp.domain.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getArticlesUseCase: GetArticlesUseCase) :
    ViewModel() {
    val articleList = MutableLiveData<List<ArticleModel>>()

    fun onCreate() {
        viewModelScope.launch {
            val response = getArticlesUseCase()
            articleList.postValue(response)
        }
    }
}