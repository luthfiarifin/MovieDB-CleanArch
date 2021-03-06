package com.laam.moviedb_cleanarch.presentation.detail.movie

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.laam.core.ext.repository.State
import com.laam.core.model.MovieEntity
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDetailViewModel(
    private val interactors: MovieDetailInteractors,
    coroutineScope: CoroutineScope? = null
) : BaseViewModel(coroutineScope) {

    @Inject
    constructor(interactors: MovieDetailInteractors) : this(interactors, null)

    private var movieId: Long = 0L

    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val isNoData: ObservableBoolean = ObservableBoolean(false)
    val movieEntity: ObservableField<MovieEntity> = ObservableField()

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        getMovie(movieId)
    }

    private val _isMovieFavorite = MutableLiveData<Boolean>()
    val isMovieFavorite: LiveData<Boolean>
        get() = _isMovieFavorite

    private val _movieError = MutableLiveData<String>()
    val movieError: LiveData<String>
        get() = _movieError

    fun getMovie(id: Long) {
        movieId = id

        getViewModelScope().launch {
            interactors.getMovieUseCase.invoke(id).collect { state ->
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
                        setMovie(state.data)
                    }
                }
            }
        }
    }

    private fun setMovie(movieEntity: MovieEntity?) {
        if (movieEntity != null)
            this.movieEntity.set(movieEntity)
        else
            this.isNoData.set(true)
    }

    fun getFavorite() {
        getViewModelScope().launch {
            withContext(Dispatchers.IO) {
                _isMovieFavorite.postValue(interactors.isMovieFavoriteUseCase.invoke(movieId))
            }
        }
    }

    fun setOnFavoriteClick() {
        getViewModelScope().launch {
            withContext(Dispatchers.IO) {
                if (isMovieFavorite.value == true) {
                    interactors.deleteMovieFavoriteUseCase.invoke(movieId)
                    _isMovieFavorite.postValue(false)
                } else {
                    movieEntity.get()?.toMovieFavoriteEntity()?.let {
                        interactors.insertMovieFavoriteUseCase.invoke(it)
                    }
                    _isMovieFavorite.postValue(true)
                }
            }
        }
    }
}