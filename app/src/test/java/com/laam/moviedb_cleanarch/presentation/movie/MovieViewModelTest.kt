package com.laam.moviedb_cleanarch.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.laam.core.ext.repository.State
import com.laam.core.model.MoviePagination
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
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var movieRepositoryImpl: MovieRepositoryImpl

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getMovieList() = runBlockingTest {
        val resultState = State.Success(MoviePagination(results = MovieDummy.generateDummyMovie()))

        `when`(movieRepositoryImpl.getAll()).thenReturn(flowOf(resultState))

        val interactors = MovieListInteractors(movieRepositoryImpl)
        viewModel = MovieViewModel(interactors, testScope)

        val list = viewModel.moviesLiveData.value
        verify(movieRepositoryImpl).getAll()
        assertNotNull(list)

        assertEquals(12, (list as State.Success?)?.data?.results?.size)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}