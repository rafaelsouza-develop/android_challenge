package com.itau.starwars_challenge.presentation.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.itau.starwars_challenge.MainDispatcherRule
import com.itau.starwars_challenge.domain.model.MovieEntity
import com.itau.starwars_challenge.domain.repository.MovieRepository
import com.itau.starwars_challenge.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


    @MockK
    lateinit var repository: MovieRepository

    @MockK
    lateinit var error: Throwable

    private val viewModel by lazy {
        spyk(
            HomeViewModel(
                movieRepository = repository
            )
        )
    }

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)

    }

    @Test
    fun `GIVEN user needs to getMovies WHEN call getMovies THEN return success `() = runTest {

        coEvery {
            repository.getMovies()
        } returns flow { listOf<MovieEntity>() }

        viewModel.dispatcherViewAction(HomeViewAction.GetMovies)

        assertEquals(HomeViewState.Loading, viewModel.viewState.value)

    }

    @Test
    fun `GIVEN user needs to getMovies WHEN call getMovies THEN return error `() = runTest {


        coEvery {
            repository.getMovies()
        } returns flow { HomeViewState.MoviesLoadFailure(error) }

        val observerMock: Observer<HomeViewState> = mockk()
        viewModel.viewState.observeForever(observerMock)

        viewModel.dispatcherViewAction(HomeViewAction.GetMovies)

        assertEquals(HomeViewState.MoviesLoadFailure(error), viewModel.viewState.getOrAwaitValue())

    }
}