package com.laam.moviedb_cleanarch.framework.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laam.core.model.MovieFavoriteEntity

@Dao
interface MovieFavoriteDao {

    @Query("SELECT * FROM movie_favorite_entities WHERE id = :id")
    fun getMovie(id: Long): MovieFavoriteEntity?

    @Query("SELECT * FROM movie_favorite_entities")
    fun getMovies(): List<MovieFavoriteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieFavoriteEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movies: MovieFavoriteEntity)

    @Query("DELETE FROM movie_favorite_entities WHERE id = :id")
    fun deleteMovie(id: Long)
}