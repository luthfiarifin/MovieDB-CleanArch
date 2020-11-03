package com.laam.core.repository

import com.laam.core.model.Movie

interface MovieRepository {

    fun getAll(): List<Movie>

    fun get(id: Long): Movie?
}