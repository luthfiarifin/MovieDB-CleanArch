package com.laam.core.repository

import com.laam.core.ext.repository.State
import com.laam.core.model.MovieEntity
import com.laam.core.model.MovieFavoriteEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getAll(page: Int): Flow<State<Pair<Int, List<MovieEntity>>>>

    suspend fun get(id: Long): Flow<State<MovieEntity?>>

    suspend fun isFavorite(id: Long): Boolean

    suspend fun insertFavorite(data: MovieFavoriteEntity)

    suspend fun deleteFavorite(id: Long)
}