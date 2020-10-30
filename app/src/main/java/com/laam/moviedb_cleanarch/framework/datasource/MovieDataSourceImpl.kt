package com.laam.moviedb_cleanarch.framework.datasource

import com.laam.core.model.Movie
import com.laam.core.repository.movie.MovieDataSource
import com.laam.moviedb_cleanarch.framework.dummy.MovieDummy
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor() : MovieDataSource {

    override fun getAll(): List<Movie> = MovieDummy.generateDummyMovie()

    override fun get(id: Long): Movie? = MovieDummy.generateDummyMovie().find { it.id == id }
}