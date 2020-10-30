package com.laam.moviedb_cleanarch.presentation.movie

import com.laam.core.repository.movie.MovieRepository
import com.laam.core.usecase.movie.GetAllMovies
import javax.inject.Inject

class MovieListInteractors @Inject constructor(
    repository: MovieRepository
) {

    val getAllMovies: GetAllMovies = GetAllMovies(repository)
}