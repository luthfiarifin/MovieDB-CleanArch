package com.laam.moviedb_cleanarch.presentation.tvshow

import android.os.Bundle
import android.view.View
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentTvBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment

class TvShowFragment : BaseFragment<FragmentTvBinding, TvShowViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_tv

    override fun getViewModel(): Class<TvShowViewModel> = TvShowViewModel::class.java

    private val rvAdapter = TvShowRecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRvAdapter()
        setUpRecycler()
    }

    private fun setUpRvAdapter() {
        rvAdapter.submitList(viewModel.tvShowList)
    }

    private fun setUpRecycler() {
        with(viewBinding.rvTvShow) {
            adapter = rvAdapter
        }
    }
}