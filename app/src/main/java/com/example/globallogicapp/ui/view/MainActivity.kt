package com.example.globallogicapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.globallogicapp.databinding.ActivityMainBinding
import com.example.globallogicapp.ui.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.onCreate()

        viewModel.articleList.observe(this, Observer {
            binding.rvArticles.layoutManager = LinearLayoutManager(this)
            binding.rvArticles.adapter = ArticlesAdapter(this, it)
        })
    }
}