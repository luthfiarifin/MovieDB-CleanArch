package com.laam.moviedb_cleanarch.presentation.tv

import android.os.Bundle
import android.view.View
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentTvBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment

class TvFragment : BaseFragment<FragmentTvBinding, TvViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_tv

    override fun getViewModel(): Class<TvViewModel> = TvViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}