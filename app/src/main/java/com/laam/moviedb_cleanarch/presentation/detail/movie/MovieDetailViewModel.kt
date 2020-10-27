package com.laam.moviedb_cleanarch.presentation.detail.movie

import androidx.databinding.ObservableField
import com.laam.core.model.Movie
import com.laam.core.repository.movie.MovieRepository
import com.laam.core.usecase.movie.GetMovie
import com.laam.moviedb_cleanarch.framework.datasource.MovieDataSourceImpl
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class MovieDetailViewModel : BaseViewModel() {

    private val repository: MovieRepository = MovieRepository(MovieDataSourceImpl())
    private val getMovie: GetMovie = GetMovie(repository)
    private val interactors: MovieDetailInteractors = MovieDetailInteractors(getMovie)

    val movie: ObservableField<Movie> = ObservableField()

    fun setMovie(id: Long) {
        movie.set(interactors.getMovie.invoke(id))
    }
}