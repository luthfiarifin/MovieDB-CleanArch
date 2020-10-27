package com.laam.core.usecase.tv

import com.laam.core.repository.tv.TvShowRepository

class GetTvShow(private val repository: TvShowRepository) {

    operator fun invoke(id: Long) = repository.getTvShow(id)
}