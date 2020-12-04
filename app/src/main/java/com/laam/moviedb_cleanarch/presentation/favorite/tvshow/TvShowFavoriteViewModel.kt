package com.laam.moviedb_cleanarch.presentation.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.laam.core.model.TvShowFavoriteEntity
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class TvShowFavoriteViewModel(
    interactors: TvShowListFavoriteInteractors,
    coroutineScope: CoroutineScope? = null
) : BaseViewModel(coroutineScope) {

    @Inject
    constructor(interactors: TvShowListFavoriteInteractors) : this(interactors, null)

    var moviesLiveData: LiveData<PagedList<TvShowFavoriteEntity>> =
        interactors.getAllTvShowFavoriteUseCase.invoke()
}