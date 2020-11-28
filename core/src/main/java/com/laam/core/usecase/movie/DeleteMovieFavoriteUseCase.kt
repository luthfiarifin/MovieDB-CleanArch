package com.laam.core.usecase.movie

import com.laam.core.repository.MovieRepository

class DeleteMovieFavoriteUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Long) = repository.deleteFavorite(id)
}