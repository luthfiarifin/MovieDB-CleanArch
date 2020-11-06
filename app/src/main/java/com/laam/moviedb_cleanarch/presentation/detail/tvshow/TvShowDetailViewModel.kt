package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.laam.core.ext.repository.State
import com.laam.core.model.Movie
import com.laam.core.model.TvShow
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class TvShowDetailViewModel @Inject constructor(
    private val interactors: TvShowDetailInteractors
) : BaseViewModel() {

    private var tvShowId: Long = 0L

    val isLoading: ObservableBoolean = ObservableBoolean(false)
    val isNoData: ObservableBoolean = ObservableBoolean(false)
    val tvShow: ObservableField<TvShow> = ObservableField()

    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        getTvShow(tvShowId)
    }

    private val _tvShowError = MutableLiveData<String>()
    val tvShowError: LiveData<String>
        get() = _tvShowError

    fun getTvShow(id: Long) {
        tvShowId = id

        viewModelScope.launch {
            interactors.getTvShow.invoke(id).collect { state ->
                when (state) {
                    is State.Loading -> {
                        isLoading.set(true)
                    }
                    is State.Success -> {
                        isLoading.set(false)
                        setTvShow(state.data)
                    }
                    is State.Error -> {
                        isLoading.set(false)
                        _tvShowError.postValue(state.message)
                    }
                }
            }
        }
    }

    private fun setTvShow(tvShow: TvShow?) {
        if (tvShow != null)
            this.tvShow.set(tvShow)
        else
            isNoData.set(true)
    }
}