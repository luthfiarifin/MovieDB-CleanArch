package com.laam.core.usecase.movie

import com.laam.core.repository.movie.MovieRepository

class GetMovie(private val repository: MovieRepository) {

    operator fun invoke(id: Long) = repository.getMovie(id)
}