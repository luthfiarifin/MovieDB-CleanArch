package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.laam.core.model.TvShow
import com.laam.core.repository.tv.TvShowRepository
import com.laam.core.usecase.tv.GetTvShow
import com.laam.moviedb_cleanarch.framework.datasource.TvShowDataSourceImpl
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel
import javax.inject.Inject

class TvShowDetailViewModel @Inject constructor(
    private val interactors: TvShowDetailInteractors
) : BaseViewModel() {

    val isNoData: ObservableBoolean = ObservableBoolean(false)
    val tvShow: ObservableField<TvShow> = ObservableField()

    fun setTvShow(id: Long) {
        val mTvShow = interactors.getTvShow.invoke(id)

        if (mTvShow != null)
            tvShow.set(mTvShow)
        else
            isNoData.set(true)
    }
}