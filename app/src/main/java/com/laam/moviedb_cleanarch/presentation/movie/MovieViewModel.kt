package com.laam.moviedb_cleanarch.presentation.movie

import androidx.databinding.ObservableBoolean
import com.laam.core.repository.movie.MovieRepository
import com.laam.core.usecase.movie.GetAllMovies
import com.laam.moviedb_cleanarch.framework.datasource.MovieDataSourceImpl
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    interactors: MovieListInteractors
) : BaseViewModel() {

    val isEmptyData: ObservableBoolean = ObservableBoolean(false)
    val movieList = interactors.getAllMovies.invoke()
}