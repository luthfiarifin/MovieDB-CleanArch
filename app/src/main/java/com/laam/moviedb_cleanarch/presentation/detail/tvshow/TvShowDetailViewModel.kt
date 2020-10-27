package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import androidx.databinding.ObservableField
import com.laam.core.model.TvShow
import com.laam.core.repository.tv.TvShowRepository
import com.laam.core.usecase.tv.GetTvShow
import com.laam.moviedb_cleanarch.framework.datasource.TvShowDataSourceImpl
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class TvShowDetailViewModel : BaseViewModel() {

    private val repository: TvShowRepository = TvShowRepository(TvShowDataSourceImpl())
    private val getTvShow: GetTvShow = GetTvShow(repository)
    private val interactors: TvShowDetailInteractors = TvShowDetailInteractors(getTvShow)

    val tvShow: ObservableField<TvShow> = ObservableField()

    fun setTvShow(id: Long) {
        tvShow.set(interactors.getTvShow.invoke(id))
    }
}