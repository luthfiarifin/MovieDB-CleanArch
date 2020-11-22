package com.laam.moviedb_cleanarch.framework.di.module

import com.laam.core.repository.MovieRepository
import com.laam.core.repository.TvShowRepository
import com.laam.moviedb_cleanarch.framework.data.local.dao.MovieDao
import com.laam.moviedb_cleanarch.framework.data.local.dao.TvShowDao
import com.laam.moviedb_cleanarch.framework.data.network.routes.MovieRoutes
import com.laam.moviedb_cleanarch.framework.data.network.routes.TvShowRoutes
import com.laam.moviedb_cleanarch.framework.repository.MovieRepositoryImpl
import com.laam.moviedb_cleanarch.framework.repository.TvShowRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    @JvmStatic
    fun provideMovieRepository(movieRoutes: MovieRoutes, movieDao: MovieDao): MovieRepository =
        MovieRepositoryImpl(movieRoutes, movieDao)


    @Provides
    @JvmStatic
    fun provideTvShowRepository(tvShowRoutes: TvShowRoutes, tvShowDao: TvShowDao): TvShowRepository =
        TvShowRepositoryImpl(tvShowRoutes, tvShowDao)
}
