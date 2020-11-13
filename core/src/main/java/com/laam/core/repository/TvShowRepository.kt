package com.laam.core.repository

import com.laam.core.ext.repository.State
import com.laam.core.model.MoviePagination
import com.laam.core.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {

    suspend fun getAll(): Flow<State<MoviePagination<TvShow>>>

    suspend fun get(id: Long): Flow<State<TvShow?>>
}