package com.laam.moviedb_cleanarch.presentation.favorite.movie

import com.laam.core.repository.MovieRepository
import com.laam.core.usecase.movie.GetAllMoviesFavoriteUseCase
import javax.inject.Inject

class MovieListFavoriteInteractors @Inject constructor(
    repository: MovieRepository
) {

    val getAllMoviesFavoriteUseCase: GetAllMoviesFavoriteUseCase =
        GetAllMoviesFavoriteUseCase(repository)
}