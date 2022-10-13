package com.itau.starwars_challenge.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itau.starwars_challenge.R
import com.itau.starwars_challenge.databinding.FragmentHomeBinding
import com.itau.starwars_challenge.domain.model.MovieEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_home)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservables(viewModel)
        viewModel.dispatcherViewAction(HomeViewAction.GetMovies)
    }

    private fun setupObservables(viewModel: HomeViewModel) {
        viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            when (viewState) {
                is HomeViewState.MoviesLoaded -> {
                    showSucessState()
                    setRecyclerViewList(viewState.movies)
                }
                HomeViewState.Loading -> {
                    showLoadingState()
                }
                is HomeViewState.MoviesLoadFailure -> {
                    goToErrorView()
                }
                HomeViewState.MoviesEmpty -> {
                    goToEmptyView()
                }
            }
        }
    }

    private fun goToErrorView() {
        findNavController().navigate(R.id.action_homeFragment_to_errorFragment)
    }

    private fun goToEmptyView() {
        findNavController().navigate(R.id.action_homeFragment_to_emptyFragment)
    }

    private fun setRecyclerViewList(movies: List<MovieEntity>) {
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MoviesAdapter(movies)
        }
    }

    private fun showLoadingState() {
        with(binding) {
            rvMovies.visibility = View.GONE
            containerLoadingState.visibility = View.VISIBLE
        }
    }

    private fun showSucessState() {
        with(binding) {
            rvMovies.visibility = View.VISIBLE
            containerLoadingState.visibility = View.GONE
        }
    }
}