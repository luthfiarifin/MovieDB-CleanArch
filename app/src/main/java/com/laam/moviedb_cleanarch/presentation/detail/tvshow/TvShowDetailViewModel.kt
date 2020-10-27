package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import androidx.databinding.ObservableField
import com.laam.core.model.TvShow
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class TvShowDetailViewModel : BaseViewModel() {

    val tvShow: ObservableField<TvShow> = ObservableField()
}