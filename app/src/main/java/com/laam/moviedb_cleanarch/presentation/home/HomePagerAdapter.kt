package com.laam.moviedb_cleanarch.presentation.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerAdapter(baseFragment: Fragment, private val listFragment: ArrayList<Fragment>) :
    FragmentStateAdapter(baseFragment) {

    override fun getItemCount(): Int = listFragment.size

    override fun createFragment(position: Int): Fragment = listFragment[position]
}