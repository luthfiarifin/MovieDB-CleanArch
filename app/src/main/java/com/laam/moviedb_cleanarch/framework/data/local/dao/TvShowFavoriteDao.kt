package com.laam.moviedb_cleanarch.framework.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laam.core.model.TvShowFavoriteEntity

@Dao
interface TvShowFavoriteDao {

    @Query("SELECT * FROM tv_show_favorite_entity WHERE id = :id")
    fun getTvShow(id: Long): TvShowFavoriteEntity?

    @Query("SELECT * FROM tv_show_favorite_entity")
    fun getTvShows(): List<TvShowFavoriteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowFavoriteEntity>)

    @Query("DELETE FROM tv_show_favorite_entity")
    fun deleteTvShows()
}