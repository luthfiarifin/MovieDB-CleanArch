package com.laam.moviedb_cleanarch.presentation.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentFavoriteBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.favorite.movie.MovieFavoriteFragment
import com.laam.moviedb_cleanarch.presentation.favorite.tvshow.TvShowFavoriteFragment
import com.laam.moviedb_cleanarch.presentation.main.MainActivity

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_favorite

    override fun getViewModel(): Class<FavoriteViewModel> = FavoriteViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle()
        setUpTabLayout()
    }

    private fun setTitle() {
        (activity as MainActivity).setTitle(getString(R.string.favorite))
    }

    private fun setUpTabLayout() {
        val fragmentList = arrayListOf<Fragment>(
            MovieFavoriteFragment(),
            TvShowFavoriteFragment()
        )

        val fragmentName = arrayListOf(
            getString(R.string.movie),
            getString(R.string.tv_show)
        )

        val pagerAdapter =
            FavoritePagerAdapter(this, fragmentList)

        viewBinding.favoriteViewPager.adapter = pagerAdapter

        TabLayoutMediator(
            viewBinding.favoriteTabLayout,
            viewBinding.favoriteViewPager
        ) { tab: TabLayout.Tab, i: Int ->
            tab.text = fragmentName[i]
        }.attach()
    }

    override fun onDestroy() {
        (activity as MainActivity).resetTitle()
        super.onDestroy()
    }
}