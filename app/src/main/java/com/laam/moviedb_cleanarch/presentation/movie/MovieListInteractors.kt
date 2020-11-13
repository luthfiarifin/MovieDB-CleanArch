package com.laam.moviedb_cleanarch.presentation.movie

import com.laam.core.repository.MovieRepository
import com.laam.core.usecase.movie.GetAllMoviesUseCase
import javax.inject.Inject

class MovieListInteractors @Inject constructor(
    repository: MovieRepository
) {

    val getAllMoviesUseCase: GetAllMoviesUseCase = GetAllMoviesUseCase(repository)
}