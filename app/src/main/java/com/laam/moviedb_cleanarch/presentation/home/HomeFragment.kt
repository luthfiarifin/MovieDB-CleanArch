package com.laam.moviedb_cleanarch.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentHomeBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment
import com.laam.moviedb_cleanarch.presentation.movie.MovieFragment
import com.laam.moviedb_cleanarch.presentation.tv.TvFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpTabLayout()
    }

    private fun setUpTabLayout() {
        val fragmentList = arrayListOf<Fragment>(
            MovieFragment(),
            TvFragment()
        )

        val fragmentName = arrayListOf(
            getString(R.string.movie),
            getString(R.string.tv)
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
}