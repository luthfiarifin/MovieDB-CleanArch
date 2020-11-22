package com.laam.moviedb_cleanarch.presentation.movie

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.laam.core.ext.repository.State
import com.laam.core.model.MovieEntity
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel(
    private val interactors: MovieListInteractors,
    coroutineScope: CoroutineScope? = null
) : BaseViewModel(coroutineScope) {

    @Inject
    constructor(interactors: MovieListInteractors) : this(interactors, null)

    var page: Int = 1

    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val isRefreshing: ObservableBoolean = ObservableBoolean(false)
    val isEmptyData: ObservableBoolean = ObservableBoolean(false)

    private val _movies = mutableListOf<MovieEntity>()
    val movies: List<MovieEntity>
        get() = _movies

    private val _moviesLiveData = MutableLiveData<State<Pair<Int, List<MovieEntity>>>>()
    val moviesLiveData: LiveData<State<Pair<Int, List<MovieEntity>>>>
        get() = _moviesLiveData

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        getMovies(true)
    }

    init {
        getMovies()
    }

    fun getMovies(isRefresh: Boolean = false) {
        getViewModelScope().launch {
            if (isRefresh) page = 1

            interactors.getAllMoviesUseCase.invoke(page).collect {
                _moviesLiveData.postValue(it)
            }
        }
    }

    fun addMovies(movies: List<MovieEntity>) {
        this._movies.addAll(movies)
    }

    fun setMovies(movies: List<MovieEntity>) {
        this._movies.clear()
        this._movies.addAll(movies)
    }
}