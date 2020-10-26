package com.laam.moviedb_cleanarch.framework.di.module

import com.laam.core.repository.movie.MovieRepository
import com.laam.core.repository.tv.TvShowRepository
import com.laam.moviedb_cleanarch.framework.datasource.MovieDataSourceImpl
import com.laam.moviedb_cleanarch.framework.datasource.TvShowDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    @JvmStatic
    fun provideMovieRepository(dataSource: MovieDataSourceImpl) =
        MovieRepository(dataSource)

    @Provides
    @JvmStatic
    fun provideTvShowRepository(dataSource: TvShowDataSourceImpl) =
        TvShowRepository(dataSource)
}
