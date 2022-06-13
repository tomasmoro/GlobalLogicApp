package com.example.globallogicapp.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.globallogicapp.R
import com.example.globallogicapp.data.model.ArticleModel
import com.example.globallogicapp.databinding.FragmentArticleListBinding
import com.example.globallogicapp.ui.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListFragment : Fragment(R.layout.fragment_article_list), OnArticleClickListener {
    private var _binding: FragmentArticleListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentArticleListBinding.bind(view)
        viewModel.onCreate()
        binding.progress.visibility = View.VISIBLE
        viewModel.articleList.observe(viewLifecycleOwner) {
            binding.apply {
                if(it.isNotEmpty())
                    binding.progress.visibility = View.GONE
                binding.rvArticles.layoutManager = LinearLayoutManager(requireContext())
                binding.rvArticles.adapter = ArticlesAdapter(requireContext(), it, this@ArticleListFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onArticleClick(article: ArticleModel) {
        val action = ArticleListFragmentDirections.actionArticleListFragmentToArticlesDetailFragment(article)
        findNavController().navigate(action)
    }

    override fun onResume() {
        super.onResume()
        (activity as MainInterface).setBackArrow(false)
    }

}