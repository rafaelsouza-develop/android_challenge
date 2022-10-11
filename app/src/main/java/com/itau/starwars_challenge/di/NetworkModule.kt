package com.itau.starwars_challenge.di

import com.google.gson.Gson
import com.itau.starwars_challenge.data.service.MovieService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.npoint.io/"

val networkModule = module {

    factory {
        Gson()
    }

    single {
        GsonConverterFactory.create(get<Gson>())
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        Retrofit.Builder()
            .addConverterFactory(get<GsonConverterFactory>())
            .baseUrl(BASE_URL)
            .client(get())
            .build()
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single { get<Retrofit>().create(MovieService::class.java) }
}