package com.itau.starwars_challenge.di

import com.itau.starwars_challenge.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(movieUsecase = get()) }
}