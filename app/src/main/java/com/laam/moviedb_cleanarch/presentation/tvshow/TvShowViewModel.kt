package com.laam.moviedb_cleanarch.presentation.tvshow

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.laam.core.ext.repository.State
import com.laam.core.model.TvShowEntity
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

    var page: Int = 1

    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val isRefreshing: ObservableBoolean = ObservableBoolean(false)
    val isEmptyData: ObservableBoolean = ObservableBoolean(false)

    private val _tvShows = mutableListOf<TvShowEntity>()
    val tvShows: List<TvShowEntity>
        get() = _tvShows

    private val _tvShowsLiveData = MutableLiveData<State<Pair<Int, List<TvShowEntity>>>>()
    val tvShowsLiveData: LiveData<State<Pair<Int, List<TvShowEntity>>>>
        get() = _tvShowsLiveData

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        getTvShows(true)
    }

    init {
        getTvShows()
    }

    fun getTvShows(isRefresh: Boolean = false) {
        getViewModelScope().launch {
            if (isRefresh) page = 1

            interactors.getAllTvShowsUseCase.invoke(page).collect {
                _tvShowsLiveData.postValue(it)
            }
        }
    }

    fun addTvShows(movies: List<TvShowEntity>) {
        this._tvShows.addAll(movies)
    }

    fun setTvShows(movies: List<TvShowEntity>) {
        this._tvShows.clear()
        this._tvShows.addAll(movies)
    }
}