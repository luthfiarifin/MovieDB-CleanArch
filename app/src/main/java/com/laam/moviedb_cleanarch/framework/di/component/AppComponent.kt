package com.laam.moviedb_cleanarch.framework.di.component

import android.app.Application
import com.laam.moviedb_cleanarch.framework.di.builder.ActivityBuilder
import com.laam.moviedb_cleanarch.framework.di.module.NetworkModule
import com.laam.moviedb_cleanarch.framework.di.module.RepositoryModule
import com.laam.moviedb_cleanarch.framework.di.module.ViewModelModule
import com.laam.moviedb_cleanarch.framework.di.module.ViewModelProviderFactoryModule
import com.laam.moviedb_cleanarch.presentation.MovieApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        ViewModelProviderFactoryModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<MovieApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}