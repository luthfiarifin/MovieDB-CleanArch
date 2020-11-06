package com.laam.core.repository

import com.laam.core.ext.repository.State
import com.laam.core.model.Movie
import com.laam.core.model.MoviePagination
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getAll(): Flow<State<MoviePagination<Movie>>>

    suspend fun get(id: Long): Flow<State<Movie?>>
}