package com.laam.core.repository

import com.laam.core.ext.repository.State
import com.laam.core.model.TvShowEntity
import com.laam.core.model.TvShowFavoriteEntity
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {

    suspend fun getAll(page: Int): Flow<State<Pair<Int, List<TvShowEntity>>>>

    suspend fun get(id: Long): Flow<State<TvShowEntity?>>

    suspend fun isFavorite(id: Long): Boolean

    suspend fun insertFavorite(data: TvShowFavoriteEntity)

    suspend fun deleteFavorite(id: Long)
}