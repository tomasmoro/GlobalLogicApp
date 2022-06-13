package com.example.globallogicapp.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.globallogicapp.R
import com.example.globallogicapp.databinding.FragmentArticlesDetailBinding

class ArticlesDetailFragment : Fragment(R.layout.fragment_articles_detail) {
    private val args by navArgs<ArticlesDetailFragmentArgs>()
    private var _binding:FragmentArticlesDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentArticlesDetailBinding.bind(view)
        (activity as MainInterface).setBackArrow(true)

        binding.apply {
            Glide.with(requireContext()).load(args.article.thumbnail).into(imgArticleDetail)
            txtDescription.text = args.article.description
            txtTitle.text = args.article.title
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}