package com.laam.moviedb_cleanarch.framework.di.module

import com.laam.core.repository.MovieRepository
import com.laam.core.repository.TvShowRepository
import com.laam.moviedb_cleanarch.framework.repository.MovieRepositoryImpl
import com.laam.moviedb_cleanarch.framework.repository.TvShowRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    @JvmStatic
    fun provideMovieRepository(): MovieRepository =
        MovieRepositoryImpl()


    @Provides
    @JvmStatic
    fun provideTvShowRepository(): TvShowRepository =
        TvShowRepositoryImpl()
}