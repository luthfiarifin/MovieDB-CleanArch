package com.laam.moviedb_cleanarch.presentation.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.framework.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var mViewBinding: VB
    private lateinit var mViewModel: VM

    val viewBinding
        get() = mViewBinding

    val viewModel
        get() = mViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = ViewModelProvider(this, factory)[getViewModel()]
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