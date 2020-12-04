package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import com.laam.moviedb_cleanarch.BuildConfig
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentTvshowDetailBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.main.MainActivity
import com.laam.moviedb_cleanarch.presentation.util.ShareUtil.shareText
import com.laam.moviedb_cleanarch.presentation.util.SnackbarUtil.showSnackbar

class TvShowDetailFragment : BaseFragment<FragmentTvshowDetailBinding, TvShowDetailViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_tvshow_detail

    override fun getViewModel(): Class<TvShowDetailViewModel> = TvShowDetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        setUpBinding()
        setUpViewModelVariable()
    }

    private fun observeTvShowError(itemFavorite: MenuItem) {
        viewModel.tvShowError.observe(viewLifecycleOwner, { message ->
            view?.showSnackbar(message)

            itemFavorite.isVisible = false
        })
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
        viewModel.getTvShow(tvShowId)
        viewModel.getFavorite()
    }

    private fun setUpBinding() {
        viewBinding.viewModel = viewModel

        viewBinding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)

        observeIsTvShowFavorite(menu.findItem(R.id.item_favorite))
        observeTvShowError(menu.findItem(R.id.item_favorite))
    }

    private fun observeIsTvShowFavorite(item: MenuItem?) {
        viewModel.isTvShowFavorite.observe(viewLifecycleOwner, { isFavorite ->
            activity?.let {
                item?.icon = if (isFavorite) {
                    ContextCompat.getDrawable(it, R.drawable.ic_favorite_active)
                } else {
                    ContextCompat.getDrawable(it, R.drawable.ic_favorite_not_active)
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_detail, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_share -> {
                onShareClick()
                true
            }
            R.id.item_favorite -> {
                viewModel.setOnFavoriteClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onShareClick() {
        activity?.shareText(
            title = resources.getString(R.string.share_this_tv_show),
            text = "${BuildConfig.WEB_URL}/tv/${viewModel.tvShowEntity.get()?.id}"
        )
    }
}