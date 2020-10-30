package com.laam.moviedb_cleanarch.presentation.tvshow

import androidx.databinding.ObservableBoolean
import com.laam.core.repository.tv.TvShowRepository
import com.laam.core.usecase.tv.GetAllTvShows
import com.laam.moviedb_cleanarch.framework.datasource.TvShowDataSourceImpl
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import javax.inject.Inject

class TvShowViewModel @Inject constructor(
    interactors: TvShowListInteractors
) : BaseViewModel() {

    val isEmptyData: ObservableBoolean = ObservableBoolean(false)
    val tvShowList = interactors.getAllTvShows.invoke()
}