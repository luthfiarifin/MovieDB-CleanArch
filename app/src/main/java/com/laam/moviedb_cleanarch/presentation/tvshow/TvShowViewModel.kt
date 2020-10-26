package com.laam.moviedb_cleanarch.presentation.tvshow

import com.laam.core.repository.tv.TvShowRepository
import com.laam.core.usecase.tv.GetAllTvShows
import com.laam.moviedb_cleanarch.framework.datasource.TvShowDataSourceImpl
import com.laam.moviedb_cleanarch.framework.model.TvShowEntity.Companion.mapFromTvShow
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class TvShowViewModel : BaseViewModel() {

    private val repository: TvShowRepository = TvShowRepository(TvShowDataSourceImpl())
    private val getAllTvShows: GetAllTvShows = GetAllTvShows(repository)
    private val interactors: TvShowListInteractors = TvShowListInteractors(getAllTvShows)

    val tvShowList = interactors.getAllTvShows.invoke().map { it.mapFromTvShow() }
}