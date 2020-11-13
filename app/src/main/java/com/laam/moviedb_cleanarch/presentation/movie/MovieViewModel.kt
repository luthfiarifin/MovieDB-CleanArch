package com.laam.moviedb_cleanarch.presentation.movie

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.laam.core.ext.repository.State
import com.laam.core.model.Movie
import com.laam.core.model.MoviePagination
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
    constructor(interactors: MovieListInteractors) : this(
        interactors, null
    )

    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val isEmptyData: ObservableBoolean = ObservableBoolean(false)

    private val _moviesLiveData = MutableLiveData<State<MoviePagination<Movie>>>()
    val moviesLiveData: LiveData<State<MoviePagination<Movie>>>
        get() = _moviesLiveData

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        getMovies()
    }

    init {
        getMovies()
    }

    private fun getMovies() {
        getViewModelScope().launch {
            interactors.getAllMoviesUseCase.invoke().collect {
                _moviesLiveData.postValue(it)
            }
        }
    }

}