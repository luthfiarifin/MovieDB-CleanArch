package com.laam.core.usecase.movie

import com.laam.core.model.MovieFavoriteEntity
import com.laam.core.repository.MovieRepository

class InsertMovieFavoriteUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(data: MovieFavoriteEntity) = repository.insertFavorite(data)
}