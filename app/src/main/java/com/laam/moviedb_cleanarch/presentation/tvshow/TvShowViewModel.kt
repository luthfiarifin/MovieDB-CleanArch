package com.laam.moviedb_cleanarch.presentation.tvshow

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.laam.core.ext.repository.State
import com.laam.core.model.MoviePagination
import com.laam.core.model.TvShow
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class TvShowViewModel(
    private val interactors: TvShowListInteractors,
    coroutineScope: CoroutineScope? = null
) : BaseViewModel(coroutineScope) {

    @Inject
    constructor(interactors: TvShowListInteractors) : this(interactors, null)

    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val isEmptyData: ObservableBoolean = ObservableBoolean(false)

    private val _tvShowsLiveData = MutableLiveData<State<MoviePagination<TvShow>>>()
    val tvShowsLiveData: LiveData<State<MoviePagination<TvShow>>>
        get() = _tvShowsLiveData

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        getTvShows()
    }

    init {
        getTvShows()
    }

    private fun getTvShows() {
        getViewModelScope().launch {
            interactors.getAllTvShowsUseCase.invoke().collect {
                _tvShowsLiveData.postValue(it)
            }
        }
    }
}