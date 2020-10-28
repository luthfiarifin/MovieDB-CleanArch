package com.laam.moviedb_cleanarch.presentation.detail.movie

import com.laam.moviedb_cleanarch.framework.dummy.MovieDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieDetailViewModelTest {

    private lateinit var viewModel: MovieDetailViewModel
    private val dummyMovie = MovieDummy.generateDummyMovie()[0]

    @Before
    fun setUp() {
        viewModel = MovieDetailViewModel()
        viewModel.setMovie(dummyMovie.id)
    }

    @Test
    fun getMovie() {
        val selectedMovie = viewModel.movie.get()
        assertNotNull(selectedMovie)

        assertEquals(dummyMovie.id, selectedMovie?.id)
        assertEquals(dummyMovie.name, selectedMovie?.name)
        assertEquals(dummyMovie.overview, selectedMovie?.overview)
        assertEquals(dummyMovie.voteAverage, selectedMovie?.voteAverage)
        assertEquals(dummyMovie.poster, selectedMovie?.poster)
        assertEquals(dummyMovie.releaseDate, selectedMovie?.releaseDate)
        assertEquals(dummyMovie.tags, selectedMovie?.tags)
    }
}