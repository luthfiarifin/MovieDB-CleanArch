package com.laam.moviedb_cleanarch.presentation.detail.movie

import androidx.databinding.ObservableField
import com.laam.core.model.Movie
import com.laam.moviedb_cleanarch.presentation.base.BaseViewModel

class MovieDetailViewModel : BaseViewModel() {

    val movie: ObservableField<Movie> = ObservableField()
}