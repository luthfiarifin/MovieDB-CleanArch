package com.laam.moviedb_cleanarch.presentation.favorite.movie

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.laam.core.model.MovieFavoriteEntity
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class MovieFavoriteViewModel(
    interactors: MovieListFavoriteInteractors,
    coroutineScope: CoroutineScope? = null
) : BaseViewModel(coroutineScope) {

    @Inject
    constructor(interactors: MovieListFavoriteInteractors) : this(interactors, null)

    var moviesLiveData: LiveData<PagedList<MovieFavoriteEntity>> =
        interactors.getAllMoviesFavoriteUseCase.invoke()
}