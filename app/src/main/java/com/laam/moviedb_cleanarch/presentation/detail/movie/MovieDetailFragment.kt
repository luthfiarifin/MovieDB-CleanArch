package com.laam.moviedb_cleanarch.presentation.detail.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentMovieDetailBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.main.MainActivity

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_movie_detail

    override fun getViewModel(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        setUpBinding()
        setUpViewModelVariable()
    }

    private fun setUpToolbar() {
        (activity as MainActivity).apply {
            setSupportActionBar(this@MovieDetailFragment.viewBinding.toolbar)
            title = ""
        }
        setHasOptionsMenu(true)
    }

    private fun setUpViewModelVariable() {
        val movieId = arguments?.let { MovieDetailFragmentArgs.fromBundle(it).movieId } ?: -1L
        viewModel.setMovie(movieId)
    }

    private fun setUpBinding() {
        viewBinding.viewModel = viewModel

        viewBinding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_share, menu)
    }
}