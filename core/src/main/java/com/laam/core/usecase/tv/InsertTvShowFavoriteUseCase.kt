package com.laam.core.usecase.tv

import com.laam.core.model.TvShowFavoriteEntity
import com.laam.core.repository.TvShowRepository

class InsertTvShowFavoriteUseCase(private val repository: TvShowRepository) {

    suspend operator fun invoke(data: TvShowFavoriteEntity) = repository.insertFavorite(data)
}