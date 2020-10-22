package com.laam.moviedb_cleanarch.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment

abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {

    private lateinit var mViewBinding: VB

    val viewBinding
        get() = mViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)

        return mViewBinding.root
    }

    abstract fun getLayoutId(): Int
}