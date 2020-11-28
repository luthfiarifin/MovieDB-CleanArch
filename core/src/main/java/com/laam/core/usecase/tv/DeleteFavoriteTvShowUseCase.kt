package com.laam.core.usecase.tv

import com.laam.core.repository.TvShowRepository

class DeleteFavoriteTvShowUseCase(private val repository: TvShowRepository) {

    suspend operator fun invoke(id: Long) = repository.deleteFavorite(id)
}