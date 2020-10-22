package com.laam.moviedb_cleanarch.framework.di.module

import androidx.lifecycle.ViewModelProvider
import com.laam.moviedb_cleanarch.framework.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelProviderFactoryModule {

    @Binds
    fun bindViewModelProviderFactoryModule(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}