package com.laam.core.usecase.tv

import com.laam.core.repository.TvShowRepository

class IsTvShowFavoriteUseCase(private val repository: TvShowRepository) {

    suspend operator fun invoke(id: Long) = repository.isFavorite(id)
}