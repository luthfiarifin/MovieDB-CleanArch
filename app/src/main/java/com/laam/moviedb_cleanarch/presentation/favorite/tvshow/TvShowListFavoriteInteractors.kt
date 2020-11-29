package com.laam.moviedb_cleanarch.presentation.favorite.tvshow

import com.laam.core.repository.TvShowRepository
import com.laam.core.usecase.tv.GetAllTvShowsFavoriteUseCase
import javax.inject.Inject

class TvShowListFavoriteInteractors @Inject constructor(
    repository: TvShowRepository
) {

    val getAllTvShowFavoriteUseCase: GetAllTvShowsFavoriteUseCase =
        GetAllTvShowsFavoriteUseCase(repository)
}