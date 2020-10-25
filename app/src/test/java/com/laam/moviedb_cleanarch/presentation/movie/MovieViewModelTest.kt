package com.laam.moviedb_cleanarch.presentation.movie

import com.laam.moviedb_cleanarch.framework.dummy.MovieDummy
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieViewModelTest {

    @Test
    fun getMovieList() {
        val list = MovieDummy.generateDummyMovie()
        assertEquals(12, list.size)
    }
}