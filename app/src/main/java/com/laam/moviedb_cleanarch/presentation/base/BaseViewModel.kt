package com.laam.moviedb_cleanarch.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

abstract class BaseViewModel(
    private val coroutineScope: CoroutineScope? = null
) : ViewModel() {

    fun getViewModelScope() = coroutineScope ?: this.viewModelScope
}