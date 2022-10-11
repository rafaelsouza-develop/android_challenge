package com.itau.starwars_challenge.di

import com.itau.starwars_challenge.data.service.MovieService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {

    factory { get<Retrofit>().create(MovieService::class.java) }
}