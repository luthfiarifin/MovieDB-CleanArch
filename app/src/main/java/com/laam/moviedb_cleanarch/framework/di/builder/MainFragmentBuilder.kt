package com.laam.moviedb_cleanarch.framework.di.builder

import com.laam.moviedb_cleanarch.presentation.detail.movie.MovieDetailFragment
import com.laam.moviedb_cleanarch.presentation.detail.tvshow.TvShowDetailFragment
import com.laam.moviedb_cleanarch.presentation.favorite.FavoriteFragment
import com.laam.moviedb_cleanarch.presentation.favorite.movie.MovieFavoriteFragment
import com.laam.moviedb_cleanarch.presentation.favorite.tvshow.TvShowFavoriteFragment
import com.laam.moviedb_cleanarch.presentation.home.HomeFragment
import com.laam.moviedb_cleanarch.presentation.movie.MovieFragment
import com.laam.moviedb_cleanarch.presentation.splash.SplashFragment
import com.laam.moviedb_cleanarch.presentation.tvshow.TvShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowFragment(): TvShowFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailFragment(): MovieDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowDetailFragment(): TvShowDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieFavoriteFragment(): MovieFavoriteFragment

    @ContributesAndroidInjector
    abstract fun contributeTvShowFavoriteFragment(): TvShowFavoriteFragment
}