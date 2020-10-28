package com.laam.moviedb_cleanarch.presentation.detail.movie

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.laam.core.model.Movie
import com.laam.core.repository.movie.MovieRepository
import com.laam.core.usecase.movie.GetMovie
import com.laam.moviedb_cleanarch.framework.datasource.MovieDataSourceImpl
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class MovieDetailViewModel : BaseViewModel() {

    val isNoData: ObservableBoolean = ObservableBoolean(false)

    private val repository: MovieRepository = MovieRepository(MovieDataSourceImpl())
    private val getMovie: GetMovie = GetMovie(repository)
    private val interactors: MovieDetailInteractors = MovieDetailInteractors(getMovie)

    val movie: ObservableField<Movie> = ObservableField()

    fun setMovie(id: Long) {
        val mMovie = interactors.getMovie.invoke(id)

        if (mMovie != null)
            movie.set(mMovie)
        else
            isNoData.set(true)
    }
}