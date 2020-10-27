package com.laam.core.usecase.tv

import com.laam.core.repository.tv.TvShowRepository

class GetAllTvShows(private val repository: TvShowRepository) {

    operator fun invoke() = repository.getAllTvShows()
}