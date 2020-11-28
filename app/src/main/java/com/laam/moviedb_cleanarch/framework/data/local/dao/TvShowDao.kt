package com.laam.moviedb_cleanarch.framework.data.local.dao

import androidx.room.*
import com.laam.core.model.TvShowEntity

@Dao
interface TvShowDao {

    @Query("SELECT * FROM tv_show_entity WHERE id = :id")
    fun getTvShow(id: Long): TvShowEntity

    @Query("SELECT * FROM tv_show_entity")
    fun getTvShows(): List<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Query("DELETE FROM tv_show_entity")
    fun deleteTvShows()

    @Transaction
    fun resetNewData(tvShows: List<TvShowEntity>) {
        deleteTvShows()
        insertTvShows(tvShows)
    }
}