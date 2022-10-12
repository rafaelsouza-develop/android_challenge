package com.itau.starwars_challenge.presentation.ui.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itau.starwars_challenge.R
import com.itau.starwars_challenge.databinding.FragmentErrorBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ErrorFragment : Fragment() {

    private val viewModel: ErrorViewModel by viewModel()
    private lateinit var binding: FragmentErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_error, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_error)
        setListners()
    }

    private fun setListners(){
        binding.btnOk.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}