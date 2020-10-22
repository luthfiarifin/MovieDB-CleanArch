package com.laam.moviedb_cleanarch.framework.di.builder

import com.laam.moviedb_cleanarch.presentation.home.HomeFragment
import com.laam.moviedb_cleanarch.presentation.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}