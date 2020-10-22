package com.laam.moviedb_cleanarch.presentation.main

import android.os.Bundle
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.ActivityMainBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int  = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}