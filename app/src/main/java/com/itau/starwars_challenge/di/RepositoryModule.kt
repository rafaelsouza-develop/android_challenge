package com.itau.starwars_challenge.di

import com.itau.starwars_challenge.data.repository.MovieRepositoryImpl
import com.itau.starwars_challenge.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<MovieRepository> { MovieRepositoryImpl(get()) }
}