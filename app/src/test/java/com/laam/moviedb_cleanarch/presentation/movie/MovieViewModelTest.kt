package com.laam.moviedb_cleanarch.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.laam.core.ext.repository.State
import com.laam.core.model.MovieEntity
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
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var movieRepositoryImpl: MovieRepositoryImpl

    @Mock
    private lateinit var observer: Observer<State<Pair<Int, List<MovieEntity>>>>

    @Mock
    private lateinit var dummyList: State<Pair<Int, List<MovieEntity>>>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getMovieList() = runBlockingTest {
        val dummyMovies = dummyList
        Mockito.`when`(movieRepositoryImpl.getAll(1)).thenReturn(flowOf(dummyMovies))

        val interactors = MovieListInteractors(movieRepositoryImpl)
        viewModel = MovieViewModel(interactors, testScope)

        val movies = viewModel.moviesLiveData.value

        Mockito.verify(movieRepositoryImpl).getAll(1)
        assertNotNull(movies)
        assertEquals(movies, dummyMovies)

        viewModel.moviesLiveData.observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}