package com.laam.moviedb_cleanarch.presentation.tv

import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import javax.inject.Inject

class TvViewModel @Inject constructor(private val interactors: TvShowListInteractors) :
    BaseViewModel() {

    val tvShowList = interactors.getAllTvShows.invoke()
}