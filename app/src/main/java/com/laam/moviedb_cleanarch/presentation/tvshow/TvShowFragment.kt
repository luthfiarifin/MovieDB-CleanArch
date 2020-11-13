package com.laam.moviedb_cleanarch.presentation.tvshow

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laam.core.ext.repository.State
import com.laam.core.model.MoviePagination
import com.laam.core.model.TvShow
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentTvBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.home.HomeFragmentDirections
import com.laam.moviedb_cleanarch.presentation.util.SnackbarUtil.showSnackbar

class TvShowFragment : BaseFragment<FragmentTvBinding, TvShowViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_tv

    override fun getViewModel(): Class<TvShowViewModel> = TvShowViewModel::class.java

    private val rvAdapter by lazy {
        TvShowRecyclerAdapter { id ->
            onItemClick(id)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewBinding()
        setUpRecycler()
        observeTvShowsData()
    }

    private fun setUpViewBinding() {
        viewBinding.viewModel = viewModel
    }

    private fun observeTvShowsData() {
        viewModel.tvShowsLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is State.Loading -> {
                    setLoading(true)
                }
                is State.Success -> {
                    setLoading(false)
                    setTvShowList(state.data)
                }
                is State.Error -> {
                    setLoading(false)
                    onError(state.message)
                }
            }
        })
    }

    private fun setTvShowList(data: MoviePagination<TvShow>) {
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
        with(viewBinding.rvTvShow) {
            adapter = rvAdapter
        }
    }

    private fun onItemClick(id: Long) {
        val action = HomeFragmentDirections.actionHomeFragmentToTvShowDetailFragment(id)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}