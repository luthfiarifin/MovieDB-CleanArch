package com.laam.moviedb_cleanarch.presentation.movie

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.laam.core.ext.repository.State
import com.laam.core.model.Movie
import com.laam.core.model.MoviePagination
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val interactors: MovieListInteractors
) : BaseViewModel() {

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
        viewModelScope.launch {
            interactors.getAllMovies.invoke().collect {
                _moviesLiveData.postValue(it)
            }
        }
    }

}