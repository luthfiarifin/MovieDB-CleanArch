package com.laam.moviedb_cleanarch.presentation.detail.movie

import android.os.Bundle
import android.view.View
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentMovieDetailBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_movie_detail

    override fun getViewModel(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBinding()
        setUpViewModelVariable()
    }

    private fun setUpViewModelVariable() {
        val movie = arguments?.let { MovieDetailFragmentArgs.fromBundle(it).movie }
        viewModel.movieEntity.set(movie)
    }

    private fun setUpBinding() {
        viewBinding.viewModel = viewModel

        viewBinding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }
}