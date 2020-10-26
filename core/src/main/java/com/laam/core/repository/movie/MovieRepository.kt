package com.laam.core.repository.movie

class MovieRepository(private val dataSource: MovieDataSource) {

    fun getAllMovies() = dataSource.getAll()
}