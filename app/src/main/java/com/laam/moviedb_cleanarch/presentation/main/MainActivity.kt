package com.laam.moviedb_cleanarch.presentation.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.ActivityMainBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpToolbar()
        setUpNavigation()
    }

    private fun setUpToolbar() {
        setSupportActionBar(viewBinding.toolbar)
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        navHostFragment.navController.let { navController ->
            navController.addOnDestinationChangedListener { _, destination, _ ->
                if (destination.id == R.id.splashFragment) supportActionBar?.hide()
                else supportActionBar?.show()
            }
        }
    }
}