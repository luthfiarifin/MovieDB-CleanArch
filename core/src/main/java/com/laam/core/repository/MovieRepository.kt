package com.laam.core.repository

import com.laam.core.ext.repository.State
import com.laam.core.model.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getAll(page: Int): Flow<State<Pair<Int, List<MovieEntity>>>>

    suspend fun get(id: Long): Flow<State<MovieEntity?>>
}