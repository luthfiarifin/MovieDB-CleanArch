package com.laam.moviedb_cleanarch.presentation.detail.movie

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.laam.core.ext.repository.State
import com.laam.core.model.Movie
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val interactors: MovieDetailInteractors
) : BaseViewModel() {

    private var movieId: Long = 0L

    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val isNoData: ObservableBoolean = ObservableBoolean(false)
    val movie: ObservableField<Movie> = ObservableField()

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        getMovie(movieId)
    }

    private val _movieError = MutableLiveData<String>()
    val movieError: LiveData<String>
        get() = _movieError

    fun getMovie(id: Long) {
        movieId = id

        viewModelScope.launch {
            interactors.getMovie.invoke(id).collect { state ->
                when (state) {
                    is State.Loading -> {
                        isLoading.set(true)
                    }
                    is State.Success -> {
                        isLoading.set(false)
                        setMovie(state.data)
                    }
                    is State.Error -> {
                        isLoading.set(false)
                        _movieError.postValue(state.message)
                    }
                }
            }
        }
    }

    private fun setMovie(movie: Movie?) {
        if (movie != null)
            this.movie.set(movie)
        else
            this.isNoData.set(true)
    }
}