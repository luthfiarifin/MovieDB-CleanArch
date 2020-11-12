package com.laam.moviedb_cleanarch.presentation.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.laam.core.ext.repository.State
import com.laam.core.model.Movie
import com.laam.moviedb_cleanarch.framework.dummy.MovieDummy
import com.laam.moviedb_cleanarch.framework.repository.MovieRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: MovieDetailViewModel
    private val dummyMovie = MovieDummy.generateDummyMovie()[0]

    @Mock
    private lateinit var movieRepositoryImpl: MovieRepositoryImpl

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getMovie() = runBlockingTest {
        val resultState: State.Success<Movie?> = State.Success(dummyMovie)
        `when`(movieRepositoryImpl.get(dummyMovie.id)).thenReturn(flowOf(resultState))

        val interactors = MovieDetailInteractors(movieRepositoryImpl)
        viewModel = MovieDetailViewModel(interactors, testScope).apply {
            getMovie(dummyMovie.id)
        }

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

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}