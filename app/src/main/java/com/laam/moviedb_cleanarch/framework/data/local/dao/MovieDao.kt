package com.laam.moviedb_cleanarch.framework.data.local.dao

import androidx.room.*
import com.laam.core.model.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_entities WHERE id = :id")
    fun getMovie(id: Long): MovieEntity

    @Query("SELECT * FROM movie_entities")
    fun getMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movie_entities")
    fun deleteMovies()

    @Transaction
    fun resetNewData(movies: List<MovieEntity>) {
        deleteMovies()
        insertMovies(movies)
    }
}