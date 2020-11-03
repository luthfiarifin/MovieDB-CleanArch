package com.laam.moviedb_cleanarch.framework.repository

import com.laam.core.model.Movie
import com.laam.core.repository.MovieRepository
import com.laam.moviedb_cleanarch.framework.dummy.MovieDummy
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor() : MovieRepository {

    override fun getAll(): List<Movie> = MovieDummy.generateDummyMovie()

    override fun get(id: Long): Movie? = MovieDummy.generateDummyMovie().find { it.id == id }
}