package com.laam.moviedb_cleanarch.framework.di.module

import com.laam.core.repository.movie.MovieRepository
import com.laam.core.repository.tv.TvShowRepository
import com.laam.core.usecase.movie.GetAllMovies
import com.laam.core.usecase.tv.GetAllTvShows
import com.laam.moviedb_cleanarch.presentation.movie.MovieListInteractors
import com.laam.moviedb_cleanarch.presentation.tv.TvShowListInteractors
import dagger.Module
import dagger.Provides

@Module
object InteractorsModule {

    @Provides
    @JvmStatic
    fun provideMovieListInteractors(repository: MovieRepository) =
        MovieListInteractors(GetAllMovies(repository))

    @Provides
    @JvmStatic
    fun provideTvShowsListInteractors(repository: TvShowRepository) =
        TvShowListInteractors(GetAllTvShows(repository))
}