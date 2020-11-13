package com.laam.core.usecase.movie

import com.laam.core.repository.MovieRepository

class GetAllMoviesUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke() = repository.getAll()
}