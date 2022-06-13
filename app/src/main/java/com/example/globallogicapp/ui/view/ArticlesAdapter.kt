package com.example.globallogicapp.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.globallogicapp.data.model.ArticleModel
import com.example.globallogicapp.databinding.ArticleItemBinding

class ArticlesAdapter(
    private val context: Context,
    private val articleList: List<ArticleModel> = listOf(),
    private val listener: OnArticleClickListener
) : RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val binding = ArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticlesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(articleList[position])
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    inner class ArticlesViewHolder(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticleModel) {
            Glide.with(context).load(article.thumbnail).into(binding.imgArticle)
            binding.apply {
                txtTitle.text = article.title
                txtDescription.text = article.description
                root.setOnClickListener {
                    listener.onArticleClick(article)
                }
            }

        }
    }
}

interface OnArticleClickListener{
    fun onArticleClick(article: ArticleModel)
}