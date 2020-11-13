package com.laam.core.usecase.movie

import com.laam.core.repository.MovieRepository

class GetMovieUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Long) = repository.get(id)
}