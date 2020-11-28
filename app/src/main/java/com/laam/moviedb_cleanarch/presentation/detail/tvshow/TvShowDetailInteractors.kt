package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import com.laam.core.repository.TvShowRepository
import com.laam.core.usecase.tv.DeleteFavoriteTvShowUseCase
import com.laam.core.usecase.tv.GetTvShowUseCase
import com.laam.core.usecase.tv.InsertTvShowFavoriteUseCase
import com.laam.core.usecase.tv.IsTvShowFavoriteUseCase
import javax.inject.Inject

class TvShowDetailInteractors @Inject constructor(
    repository: TvShowRepository
) {

    val getTvShowUseCase: GetTvShowUseCase = GetTvShowUseCase(repository)

    val isTvShowFavoriteUseCase: IsTvShowFavoriteUseCase = IsTvShowFavoriteUseCase(repository)

    val insertTvShowFavoriteUseCase: InsertTvShowFavoriteUseCase =
        InsertTvShowFavoriteUseCase(repository)

    val deleteFavoriteTvShowUseCase: DeleteFavoriteTvShowUseCase =
        DeleteFavoriteTvShowUseCase(repository)
}