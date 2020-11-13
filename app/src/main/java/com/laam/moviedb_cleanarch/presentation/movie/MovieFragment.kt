package com.laam.moviedb_cleanarch.presentation.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.laam.core.ext.repository.State
import com.laam.core.model.Movie
import com.laam.core.model.MoviePagination
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentMovieBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.home.HomeFragmentDirections
import com.laam.moviedb_cleanarch.presentation.util.SnackbarUtil.showSnackbar

class MovieFragment : BaseFragment<FragmentMovieBinding, MovieViewModel>(),
    MovieRecyclerAdapter.Callback {

    override fun getLayoutId(): Int = R.layout.fragment_movie

    override fun getViewModel(): Class<MovieViewModel> = MovieViewModel::class.java

    private val rvAdapter = MovieRecyclerAdapter(this)

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
        viewModel.moviesLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is State.Loading -> {
                    setLoading(true)
                }
                is State.Success -> {
                    setLoading(false)
                    setMovieList(state.data)
                }
                is State.Error -> {
                    setLoading(false)
                    onError(state.message)
                }
            }
        })
    }

    private fun setMovieList(data: MoviePagination<Movie>) {
        if (data.results.isNotEmpty()) rvAdapter.submitList(data.results)
        else viewModel.isEmptyData.set(true)
    }

    private fun onError(message: String) {
        view?.showSnackbar(message)
    }

    private fun setLoading(boolean: Boolean) {
        viewModel.isLoading.set(boolean)
    }

    private fun setUpRecycler() {
        with(viewBinding.rvMovie) {
            adapter = rvAdapter
        }
    }

    override fun onItemClick(id: Long) {
        val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(id)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}