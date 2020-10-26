package com.laam.moviedb_cleanarch.presentation.movie

import android.os.Bundle
import android.view.View
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentMovieBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment

class MovieFragment : BaseFragment<FragmentMovieBinding, MovieViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_movie

    override fun getViewModel(): Class<MovieViewModel> = MovieViewModel::class.java

    private val rvAdapter = MovieRecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRvAdapter()
        setUpRecycler()
    }

    private fun setUpRvAdapter() {
        rvAdapter.submitList(viewModel.movieList)
    }

    private fun setUpRecycler() {
        with(viewBinding.rvMovie) {
            adapter = rvAdapter
        }
    }
}