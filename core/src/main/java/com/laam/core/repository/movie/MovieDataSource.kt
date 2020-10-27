package com.laam.core.repository.movie

import com.laam.core.model.Movie

interface MovieDataSource {

    fun getAll(): List<Movie>

    fun get(id: Long): Movie?
}