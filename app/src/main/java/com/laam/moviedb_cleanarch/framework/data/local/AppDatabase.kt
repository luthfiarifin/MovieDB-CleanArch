package com.laam.moviedb_cleanarch.framework.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.laam.core.model.MovieEntity
import com.laam.core.model.MovieFavoriteEntity
import com.laam.core.model.TvShowEntity
import com.laam.core.model.TvShowFavoriteEntity
import com.laam.moviedb_cleanarch.framework.data.local.dao.MovieDao
import com.laam.moviedb_cleanarch.framework.data.local.dao.MovieFavoriteDao
import com.laam.moviedb_cleanarch.framework.data.local.dao.TvShowDao
import com.laam.moviedb_cleanarch.framework.data.local.dao.TvShowFavoriteDao

@Database(
    entities = [
        MovieEntity::class,
        TvShowEntity::class,
        MovieFavoriteEntity::class,
        TvShowFavoriteEntity::class
    ],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "movie.db"

        fun create(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun movieFavoriteDao(): MovieFavoriteDao
    abstract fun tvShowFavoriteDao(): TvShowFavoriteDao
}