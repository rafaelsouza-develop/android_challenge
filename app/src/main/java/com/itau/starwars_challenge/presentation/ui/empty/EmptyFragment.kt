package com.itau.starwars_challenge.presentation.ui.empty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itau.starwars_challenge.R
import com.itau.starwars_challenge.databinding.FragmentEmptyBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

class EmptyFragment : Fragment() {

    private val viewModel: EmptyViewModel by viewModel()
    private lateinit var binding: FragmentEmptyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_empty, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_empty)
        setListners()
    }

    private fun setListners(){
        binding.btnOk.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}