package com.laam.moviedb_cleanarch.presentation.tvshow

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentTvBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.home.HomeFragmentDirections

class TvShowFragment : BaseFragment<FragmentTvBinding, TvShowViewModel>(),
    TvShowRecyclerAdapter.Callback {

    override fun getLayoutId(): Int = R.layout.fragment_tv

    override fun getViewModel(): Class<TvShowViewModel> = TvShowViewModel::class.java

    private val rvAdapter = TvShowRecyclerAdapter(this)

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
        val list = viewModel.tvShowList

        if (list.isNotEmpty())
            rvAdapter.submitList(list)
        else
            viewModel.isEmptyData.set(true)
    }

    private fun setUpRecycler() {
        with(viewBinding.rvTvShow) {
            adapter = rvAdapter
        }
    }

    override fun onItemClick(id: Long) {
        val action = HomeFragmentDirections.actionHomeFragmentToTvShowDetailFragment(id)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}