package com.laam.moviedb_cleanarch.presentation.movie

import com.laam.core.usecase.movie.GetAllMovies

data class MovieListInteractors(

    val getAllMovies: GetAllMovies
)