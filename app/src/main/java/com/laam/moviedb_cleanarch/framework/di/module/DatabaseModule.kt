package com.laam.moviedb_cleanarch.framework.di.module

import android.app.Application
import com.laam.moviedb_cleanarch.framework.data.local.AppDatabase
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {

    @Provides
    @JvmStatic
    fun provideAppDatabase(application: Application) =
        AppDatabase.create(application)

    @Provides
    @JvmStatic
    fun provideMovieDao(appDatabase: AppDatabase) =
        appDatabase.movieDao()

    @Provides
    @JvmStatic
    fun provideTvShowDao(appDatabase: AppDatabase) =
        appDatabase.tvShowDao()
}