package com.laam.moviedb_cleanarch.presentation.favorite.tvshow

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentTvshowFavoriteBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.favorite.FavoriteFragmentDirections

class TvShowFavoriteFragment :
    BaseFragment<FragmentTvshowFavoriteBinding, TvShowFavoriteViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_tvshow_favorite

    override fun getViewModel(): Class<TvShowFavoriteViewModel> =
        TvShowFavoriteViewModel::class.java

    private val rvAdapter by lazy {
        TvShowFavoriteRecyclerAdapter { id ->
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
        viewModel.tvShowsLiveData.observe(viewLifecycleOwner, {
            rvAdapter.submitList(it)
        })
    }

    private fun setUpRecycler() {
        with(viewBinding.rvTvShow) {
            adapter = rvAdapter
        }
    }

    private fun onItemClick(id: Long) {
        val action = FavoriteFragmentDirections.actionFavoriteFragmentToTvShowDetailFragment(id)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}