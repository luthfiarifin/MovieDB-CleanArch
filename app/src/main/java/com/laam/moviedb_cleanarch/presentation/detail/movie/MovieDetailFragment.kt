package com.laam.moviedb_cleanarch.presentation.detail.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.app.ShareCompat
import androidx.fragment.app.FragmentActivity
import com.laam.moviedb_cleanarch.BuildConfig
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentMovieDetailBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.main.MainActivity
import com.laam.moviedb_cleanarch.presentation.util.ShareUtil.shareText

class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding, MovieDetailViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_movie_detail

    override fun getViewModel(): Class<MovieDetailViewModel> = MovieDetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        setUpBinding()
        setUpViewModelVariable()
    }

    private fun setUpToolbar() {
        (activity as MainActivity).apply {
            setSupportActionBar(this@MovieDetailFragment.viewBinding.toolbar)
            title = ""
        }
        setHasOptionsMenu(true)
    }

    private fun setUpViewModelVariable() {
        val movieId = arguments?.let { MovieDetailFragmentArgs.fromBundle(it).movieId } ?: -1L
        viewModel.setMovie(movieId)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_share -> {
                onShareClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onShareClick() {
        activity?.shareText(
            title = resources.getString(R.string.share_this_movie),
            text = "${BuildConfig.WEB_URL}/movie/${viewModel.movie.get()?.id}"
        )
    }
}