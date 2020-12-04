package com.laam.moviedb_cleanarch.presentation.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentHomeBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.movie.MovieFragment
import com.laam.moviedb_cleanarch.presentation.tvshow.TvShowFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpTabLayout()
        setUpToolbar()
    }

    private fun setUpToolbar() {
        setHasOptionsMenu(true)
    }

    private fun setUpTabLayout() {
        val fragmentList = arrayListOf<Fragment>(
            MovieFragment(),
            TvShowFragment()
        )

        val fragmentName = arrayListOf(
            getString(R.string.movie),
            getString(R.string.tv_show)
        )

        val pagerAdapter =
            HomePagerAdapter(this, fragmentList)

        viewBinding.homeViewPager.adapter = pagerAdapter

        TabLayoutMediator(
            viewBinding.homeTabLayout,
            viewBinding.homeViewPager
        ) { tab: TabLayout.Tab, i: Int ->
            tab.text = fragmentName[i]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_favorite, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_favorite -> {
                redirectToFavoritePage()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun redirectToFavoritePage() {
        val action = HomeFragmentDirections.actionHomeFragmentToFavoriteFragment()
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}