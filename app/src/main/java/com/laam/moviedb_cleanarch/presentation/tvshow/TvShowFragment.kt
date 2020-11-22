package com.laam.moviedb_cleanarch.presentation.tvshow

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laam.core.ext.repository.State
import com.laam.core.model.TvShowEntity
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentTvBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.home.HomeFragmentDirections
import com.laam.moviedb_cleanarch.presentation.util.RecyclerViewUtil.setLoadMore
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
        viewBinding.rvTvShow.setLoadMore {
            if (viewModel.page != -1) viewModel.getTvShows()
        }
    }

    private fun observeTvShowsData() {
        viewModel.tvShowsLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is State.Loading -> {
                    setLoading(true)
                }
                is State.Success -> {
                    setLoading(false)
                    setTvShowList(state.data.second)
                    setPaging(state.data.first)
                }
                is State.Error -> {
                    setLoading(false)
                    onError(state.message)
                    setTvShowList(state.data?.second ?: listOf())
                    setPaging(state.data?.first ?: -1)
                }
            }
        })
    }

    private fun setTvShowList(data: List<TvShowEntity>) {
        if (data.isEmpty() && viewModel.page == 1) viewModel.isEmptyData.set(true)
        else {
            if (viewModel.page == 1) viewModel.setTvShows(data) else viewModel.addTvShows(data)
            rvAdapter.submitList(viewModel.tvShows)
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
        with(viewBinding.rvTvShow) {
            adapter = rvAdapter
        }
    }

    private fun onItemClick(id: Long) {
        val action = HomeFragmentDirections.actionHomeFragmentToTvShowDetailFragment(id)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}