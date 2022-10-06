package com.itau.starwars_challenge.di

import com.itau.starwars_challenge.domain.usecase.MovieUsecase
import com.itau.starwars_challenge.domain.usecase.MovieUsecaseImpl
import org.koin.dsl.module

val usecaseModule = module {
    factory<MovieUsecase> {  MovieUsecaseImpl(movieRepository = get())}
}