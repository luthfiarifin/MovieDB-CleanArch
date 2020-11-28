package com.laam.moviedb_cleanarch.presentation.detail.movie

import com.laam.core.repository.MovieRepository
import com.laam.core.usecase.movie.GetMovieUseCase
import com.laam.core.usecase.movie.InsertMovieFavoriteUseCase
import com.laam.core.usecase.movie.IsMovieFavoriteUseCase
import javax.inject.Inject

class MovieDetailInteractors @Inject constructor(
    repository: MovieRepository
) {

    val getMovieUseCase: GetMovieUseCase = GetMovieUseCase(repository)

    val isMovieFavoriteUseCase: IsMovieFavoriteUseCase = IsMovieFavoriteUseCase(repository)

    val insertMovieFavoriteUseCase: InsertMovieFavoriteUseCase =
        InsertMovieFavoriteUseCase(repository)
}