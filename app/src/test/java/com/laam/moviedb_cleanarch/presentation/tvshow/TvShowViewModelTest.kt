package com.laam.moviedb_cleanarch.presentation.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.laam.core.ext.repository.State
import com.laam.core.model.MoviePagination
import com.laam.moviedb_cleanarch.framework.dummy.TvShowDummy
import com.laam.moviedb_cleanarch.framework.repository.TvShowRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var tvShowRepositoryImpl: TvShowRepositoryImpl

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getTvShows() = runBlockingTest {
        val resultState =
            State.Success(MoviePagination(results = TvShowDummy.generateDummyTvShow()))

        Mockito.`when`(tvShowRepositoryImpl.getAll()).thenReturn(flowOf(resultState))

        val interactors = TvShowListInteractors(tvShowRepositoryImpl)
        viewModel = TvShowViewModel(interactors, testScope)

        val list = viewModel.tvShowsLiveData.value
        Mockito.verify(tvShowRepositoryImpl).getAll()
        Assert.assertNotNull(list)

        Assert.assertEquals(12, (list as State.Success?)?.data?.results?.size)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}