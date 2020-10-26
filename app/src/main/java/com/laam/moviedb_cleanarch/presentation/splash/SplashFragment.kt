package com.laam.moviedb_cleanarch.presentation.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.Navigation
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.FragmentSplashBinding
import com.laam.moviedb_cleanarch.presentation.base.BaseFragment

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun getViewModel(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            navigateToHome()
        }, 2000)
    }

    private fun navigateToHome() {
        val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}