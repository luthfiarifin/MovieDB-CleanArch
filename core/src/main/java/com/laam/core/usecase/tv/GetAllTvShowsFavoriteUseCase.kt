package com.laam.core.usecase.tv

import com.laam.core.repository.TvShowRepository

class GetAllTvShowsFavoriteUseCase(private val repository: TvShowRepository) {

    operator fun invoke() = repository.getAllFavorite()
}