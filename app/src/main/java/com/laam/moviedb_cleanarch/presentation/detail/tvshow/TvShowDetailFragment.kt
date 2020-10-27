package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import android.os.Bundle
import android.view.View
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentTvshowDetailBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment

class TvShowDetailFragment : BaseFragment<FragmentTvshowDetailBinding, TvShowDetailViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_tvshow_detail

    override fun getViewModel(): Class<TvShowDetailViewModel> = TvShowDetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBinding()
        setUpViewModelVariable()
    }

    private fun setUpViewModelVariable() {
        val tvShow = arguments?.let { TvShowDetailFragmentArgs.fromBundle(it).tvShow }
        viewModel.tvShowEntity.set(tvShow)
    }

    private fun setUpBinding() {
        viewBinding.viewModel = viewModel

        viewBinding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }
}