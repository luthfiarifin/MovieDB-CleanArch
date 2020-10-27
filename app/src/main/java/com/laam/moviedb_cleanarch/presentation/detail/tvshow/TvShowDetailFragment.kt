package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentTvshowDetailBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.main.MainActivity

class TvShowDetailFragment : BaseFragment<FragmentTvshowDetailBinding, TvShowDetailViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_tvshow_detail

    override fun getViewModel(): Class<TvShowDetailViewModel> = TvShowDetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        setUpBinding()
        setUpViewModelVariable()
    }

    private fun setUpToolbar() {
        (activity as MainActivity).apply {
            setSupportActionBar(this@TvShowDetailFragment.viewBinding.toolbar)
            title = ""
        }
        setHasOptionsMenu(true)
    }

    private fun setUpViewModelVariable() {
        val tvShowId = arguments?.let { TvShowDetailFragmentArgs.fromBundle(it).tvShowId } ?: -1L
        viewModel.setTvShow(tvShowId)
    }

    private fun setUpBinding() {
        viewBinding.viewModel = viewModel

        viewBinding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_share, menu)
    }
}