package com.laam.moviedb_cleanarch.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laam.moviedb_cleanarch.R

abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    private lateinit var mViewBinding: VB
    private lateinit var mViewModel: VM

    val viewBinding
        get() = mViewBinding

    val viewModel
        get() = mViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = ViewModelProvider(this)[getViewModel()]
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getLayoutId(): Int

    fun setAsChildActivity() {
        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        }
    }
}