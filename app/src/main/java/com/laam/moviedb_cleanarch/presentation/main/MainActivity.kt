package com.laam.moviedb_cleanarch.presentation.main

import android.os.Bundle
import android.view.View
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
        val fragmentWithoutToolbar = arrayListOf(
            R.id.splashFragment,
            R.id.movieDetailFragment,
            R.id.tvShowDetailFragment
        )

        val fragmentWithBackButton = arrayListOf(
            R.id.favoriteFragment
        )

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment

        navHostFragment.navController.let { navController ->
            navController.addOnDestinationChangedListener { _, destination, _ ->
                if (destination.id in fragmentWithoutToolbar) {
                    showToolbar(false)
                } else {
                    setUpToolbar()
                    showToolbar(true)
                }

                if (destination.id in fragmentWithBackButton) showBackButton(true)
                else showBackButton(false)
            }
        }
    }

    private fun showToolbar(b: Boolean) {
        if (b) supportActionBar?.show() else supportActionBar?.hide()
    }

    private fun showBackButton(b: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(b)
        supportActionBar?.setDisplayShowHomeEnabled(b)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun setTitle(title: String) {
        viewBinding.toolbar.title = title
    }

    fun resetTitle() {
        viewBinding.toolbar.title = getString(R.string.app_name)
    }
}