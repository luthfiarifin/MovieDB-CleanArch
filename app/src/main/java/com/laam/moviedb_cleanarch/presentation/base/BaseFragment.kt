package com.laam.moviedb_cleanarch.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<VB : ViewDataBinding, VM : ViewModel> : Fragment() {

    private lateinit var mViewBinding: VB
    private lateinit var mViewModel: VM

    val viewBinding
        get() = mViewBinding

    val viewModel
        get() = mViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mViewModel = ViewModelProvider(this)[getViewModel()]

        return mViewBinding.root
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getLayoutId(): Int
}