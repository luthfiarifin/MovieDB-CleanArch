package com.laam.core.usecase.movie

import com.laam.core.repository.MovieRepository

class GetAllMovies(private val repository: MovieRepository) {

    operator fun invoke() = repository.getAll()
}