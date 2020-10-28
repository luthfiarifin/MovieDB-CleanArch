package com.laam.moviedb_cleanarch.presentation.movie

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentMovieBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.home.HomeFragmentDirections

class MovieFragment : BaseFragment<FragmentMovieBinding, MovieViewModel>(),
    MovieRecyclerAdapter.Callback {

    override fun getLayoutId(): Int = R.layout.fragment_movie

    override fun getViewModel(): Class<MovieViewModel> = MovieViewModel::class.java

    private val rvAdapter = MovieRecyclerAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewBinding()
        setUpRvAdapter()
        setUpRecycler()
    }

    private fun setUpViewBinding() {
        viewBinding.viewModel = viewModel
    }

    private fun setUpRvAdapter() {
        val list = viewModel.movieList

        if (list.isNotEmpty())
            rvAdapter.submitList(list)
        else
            viewModel.isEmptyData.set(true)
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