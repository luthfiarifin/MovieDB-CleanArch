package com.laam.moviedb_cleanarch.presentation.tvshow

import com.laam.core.repository.TvShowRepository
import com.laam.core.usecase.tv.GetAllTvShows
import javax.inject.Inject

class TvShowListInteractors @Inject constructor(
    repository: TvShowRepository
) {

    val getAllTvShows: GetAllTvShows = GetAllTvShows(repository)
}