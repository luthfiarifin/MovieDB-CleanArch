package com.laam.moviedb_cleanarch.presentation.detail.movie

import com.laam.core.repository.movie.MovieRepository
import com.laam.core.usecase.movie.GetMovie
import javax.inject.Inject

class MovieDetailInteractors @Inject constructor(
    repository: MovieRepository
) {

    val getMovie: GetMovie = GetMovie(repository)
}