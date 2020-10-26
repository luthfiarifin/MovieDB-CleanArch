package com.laam.moviedb_cleanarch.framework.di.module

import androidx.lifecycle.ViewModel
import com.laam.moviedb_cleanarch.framework.viewmodel.ViewModelKey
import com.laam.moviedb_cleanarch.presentation.home.HomeViewModel
import com.laam.moviedb_cleanarch.presentation.main.MainViewModel
import com.laam.moviedb_cleanarch.presentation.movie.MovieViewModel
import com.laam.moviedb_cleanarch.presentation.splash.SplashViewModel
import com.laam.moviedb_cleanarch.presentation.tv.TvViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindMovieViewModel(viewModel: MovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TvViewModel::class)
    abstract fun bindTvViewModel(viewModel: TvViewModel): ViewModel
}