package com.laam.moviedb_cleanarch.presentation.movie

import com.laam.core.repository.movie.MovieRepository
import com.laam.core.usecase.movie.GetAllMovies
import com.laam.moviedb_cleanarch.framework.datasource.MovieDataSourceImpl
import com.laam.moviedb_cleanarch.framework.model.MovieEntity.Companion.mapFromMovie
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class MovieViewModel : BaseViewModel() {

    private val repository: MovieRepository = MovieRepository(MovieDataSourceImpl())
    private val getAllMovies: GetAllMovies = GetAllMovies(repository)
    private val interactors: MovieListInteractors = MovieListInteractors(getAllMovies)

    val movieList = interactors.getAllMovies.invoke().map { it.mapFromMovie() }
}