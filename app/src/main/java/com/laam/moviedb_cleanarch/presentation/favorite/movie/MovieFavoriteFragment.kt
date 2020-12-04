package com.laam.moviedb_cleanarch.presentation.favorite.movie

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentMovieFavoriteBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.favorite.FavoriteFragmentDirections

class MovieFavoriteFragment : BaseFragment<FragmentMovieFavoriteBinding, MovieFavoriteViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_movie_favorite

    override fun getViewModel(): Class<MovieFavoriteViewModel> = MovieFavoriteViewModel::class.java

    private val rvAdapter by lazy {
        MovieFavoriteRecyclerAdapter { id ->
            onItemClick(id)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewBinding()
        setUpRecycler()
        observeMoviesData()
    }

    private fun setUpViewBinding() {
        viewBinding.viewModel = viewModel
    }

    private fun observeMoviesData() {
        viewModel.moviesLiveData.observe(viewLifecycleOwner, {
            rvAdapter.submitList(it)
        })
    }

    private fun setUpRecycler() {
        with(viewBinding.rvMovie) {
            adapter = rvAdapter
        }
    }

    private fun onItemClick(id: Long) {
        val action = FavoriteFragmentDirections.actionFavoriteFragmentToMovieDetailFragment(id)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}