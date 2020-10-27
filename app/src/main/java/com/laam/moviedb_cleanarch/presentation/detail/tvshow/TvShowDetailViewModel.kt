package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import androidx.databinding.ObservableField
import com.laam.moviedb_cleanarch.framework.model.TvShowEntity
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class TvShowDetailViewModel : BaseViewModel() {

    val tvShowEntity: ObservableField<TvShowEntity> = ObservableField()
}