package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import com.laam.core.repository.tv.TvShowRepository
import com.laam.core.usecase.tv.GetTvShow
import javax.inject.Inject

class TvShowDetailInteractors @Inject constructor(
    repository: TvShowRepository
) {

    val getTvShow: GetTvShow = GetTvShow(repository)
}