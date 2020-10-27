package com.laam.moviedb_cleanarch.framework.datasource

import com.laam.core.model.Movie
import com.laam.core.repository.movie.MovieDataSource
import com.laam.moviedb_cleanarch.framework.dummy.MovieDummy

class MovieDataSourceImpl : MovieDataSource {

    override fun getAll(): List<Movie> = MovieDummy.generateDummyMovie()
}