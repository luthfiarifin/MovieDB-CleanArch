package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import com.laam.core.repository.TvShowRepository
import com.laam.core.usecase.tv.GetTvShowUseCase
import javax.inject.Inject

class TvShowDetailInteractors @Inject constructor(
    repository: TvShowRepository
) {

    val getTvShowUseCase: GetTvShowUseCase = GetTvShowUseCase(repository)
}