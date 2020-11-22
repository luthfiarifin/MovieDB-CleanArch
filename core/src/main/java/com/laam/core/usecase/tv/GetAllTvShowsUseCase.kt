package com.laam.core.usecase.tv

import com.laam.core.repository.TvShowRepository

class GetAllTvShowsUseCase(private val repository: TvShowRepository) {

    suspend operator fun invoke(page: Int) = repository.getAll(page)
}