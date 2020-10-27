package com.laam.moviedb_cleanarch.presentation.detail.movie

import androidx.databinding.ObservableField
import com.laam.moviedb_cleanarch.framework.model.MovieEntity
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class MovieDetailViewModel : BaseViewModel() {

    val movieEntity: ObservableField<MovieEntity> = ObservableField()
}