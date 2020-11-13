package com.laam.moviedb_cleanarch.presentation.tvshow

import com.laam.core.repository.TvShowRepository
import com.laam.core.usecase.tv.GetAllTvShowsUseCase
import javax.inject.Inject

class TvShowListInteractors @Inject constructor(
    repository: TvShowRepository
) {

    val getAllTvShowsUseCase: GetAllTvShowsUseCase = GetAllTvShowsUseCase(repository)
}