package com.laam.core.usecase.tv

import com.laam.core.repository.TvShowRepository

class GetTvShow(private val repository: TvShowRepository) {

    operator fun invoke(id: Long) = repository.get(id)
}