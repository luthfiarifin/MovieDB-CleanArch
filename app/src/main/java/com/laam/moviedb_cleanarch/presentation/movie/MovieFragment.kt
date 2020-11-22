package com.laam.moviedb_cleanarch.presentation.movie

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laam.core.ext.repository.State
import com.laam.core.model.MovieEntity
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentMovieBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.home.HomeFragmentDirections
import com.laam.moviedb_cleanarch.presentation.util.RecyclerViewUtil.setLoadMore
import com.laam.moviedb_cleanarch.presentation.util.SnackbarUtil.showSnackbar

class MovieFragment : BaseFragment<FragmentMovieBinding, MovieViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_movie

    override fun getViewModel(): Class<MovieViewModel> = MovieViewModel::class.java

    private val rvAdapter by lazy {
        MovieRecyclerAdapter { id ->
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
        viewBinding.rvMovie.setLoadMore {
            if (viewModel.page != -1) viewModel.getMovies()
        }
    }

    private fun observeMoviesData() {
        viewModel.moviesLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is State.Loading -> {
                    setLoading(true)
                }
                is State.Success -> {
                    setLoading(false)
                    setMovieList(state.data.second)
                    setPaging(state.data.first)
                }
                is State.Error -> {
                    setLoading(false)
                    onError(state.message)
                    setMovieList(state.data?.second ?: listOf())
                    setPaging(state.data?.first ?: -1)
                }
            }
        })
    }

    private fun setMovieList(data: List<MovieEntity>) {
        if (data.isEmpty() && viewModel.page == 1) viewModel.isEmptyData.set(true)
        else {
            if (viewModel.page == 1) viewModel.setMovies(data) else viewModel.addMovies(data)
            rvAdapter.submitList(viewModel.movies)
            viewModel.isEmptyData.set(false)
        }
    }

    private fun setLoading(boolean: Boolean) {
        if (viewModel.page == 1) viewModel.isRefreshing.set(boolean)
        else viewModel.isLoading.set(boolean)
    }

    private fun setPaging(page: Int) {
        viewModel.page = page
    }

    private fun onError(message: String) {
        view?.showSnackbar(message)
    }

    private fun setUpRecycler() {
        with(viewBinding.rvMovie) {
            adapter = rvAdapter
        }
    }

    private fun onItemClick(id: Long) {
        val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(id)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}