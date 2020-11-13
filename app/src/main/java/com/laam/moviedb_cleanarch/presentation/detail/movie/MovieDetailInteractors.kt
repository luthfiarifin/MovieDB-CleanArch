package com.laam.moviedb_cleanarch.presentation.detail.movie

import com.laam.core.repository.MovieRepository
import com.laam.core.usecase.movie.GetMovieUseCase
import javax.inject.Inject

class MovieDetailInteractors @Inject constructor(
    repository: MovieRepository
) {

    val getMovieUseCase: GetMovieUseCase = GetMovieUseCase(repository)
}