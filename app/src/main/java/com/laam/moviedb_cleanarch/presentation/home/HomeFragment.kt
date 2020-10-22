package com.laam.moviedb_cleanarch.presentation.home

import android.os.Bundle
import android.view.View
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentHomeBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}