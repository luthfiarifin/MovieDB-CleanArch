package com.laam.moviedb_cleanarch.presentation.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.laam.core.ext.repository.State
import com.laam.core.model.TvShowEntity
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

    @Mock
    private lateinit var observer: Observer<State<Pair<Int, List<TvShowEntity>>>>

    @Mock
    private lateinit var dummyList: State<Pair<Int, List<TvShowEntity>>>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getTvShows() = runBlockingTest {
        val dummyTvShows = dummyList
        Mockito.`when`(tvShowRepositoryImpl.getAll(1)).thenReturn(flowOf(dummyTvShows))

        val interactors = TvShowListInteractors(tvShowRepositoryImpl)
        viewModel = TvShowViewModel(interactors, testScope)

        val tvShows = viewModel.tvShowsLiveData.value

        Mockito.verify(tvShowRepositoryImpl).getAll(1)
        Assert.assertNotNull(tvShows)
        Assert.assertEquals(tvShows, dummyTvShows)

        viewModel.tvShowsLiveData.observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}