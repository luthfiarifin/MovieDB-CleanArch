package com.laam.moviedb_cleanarch.presentation.movie

import androidx.databinding.ObservableBoolean
import com.laam.core.repository.movie.MovieRepository
import com.laam.core.usecase.movie.GetAllMovies
import com.laam.moviedb_cleanarch.framework.datasource.MovieDataSourceImpl
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class MovieViewModel : BaseViewModel() {

    val isEmptyData: ObservableBoolean = ObservableBoolean(false)

    private val repository: MovieRepository = MovieRepository(MovieDataSourceImpl())
    private val getAllMovies: GetAllMovies = GetAllMovies(repository)
    private val interactors: MovieListInteractors = MovieListInteractors(getAllMovies)

    val movieList = interactors.getAllMovies.invoke()
}