package com.laam.moviedb_cleanarch.presentation.movie

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovieList() {
        val list = viewModel.movieList
        assertEquals(12, list.size)
    }
}