package com.laam.moviedb_cleanarch.framework.di.module

import com.laam.moviedb_cleanarch.framework.data.network.AppNetwork
import com.laam.moviedb_cleanarch.framework.data.network.routes.MovieRoutes
import com.laam.moviedb_cleanarch.framework.data.network.routes.TvShowRoutes
import dagger.Module
import dagger.Provides

@Module
object NetworkModule {

    @JvmStatic
    @Provides
    fun provideMovieRoutes(): MovieRoutes =
        AppNetwork.createMovieNetwork().create(MovieRoutes::class.java)

    @JvmStatic
    @Provides
    fun provideTvShowRoutes(): TvShowRoutes =
        AppNetwork.createMovieNetwork().create(TvShowRoutes::class.java)
}