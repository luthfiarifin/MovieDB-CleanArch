package com.laam.core.usecase.tv

import com.laam.core.repository.TvShowRepository

class GetAllTvShows(private val repository: TvShowRepository) {

    suspend operator fun invoke() = repository.getAll()
}