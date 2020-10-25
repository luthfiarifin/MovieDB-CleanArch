package com.laam.moviedb_cleanarch.presentation.movie

import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val interactors: MovieListInteractors) :
    BaseViewModel() {

    val movieList = interactors.getAllMovies.invoke()
}