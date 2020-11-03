package com.laam.moviedb_cleanarch.framework.di.builder

import com.laam.moviedb_cleanarch.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [MainFragmentBuilder::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}