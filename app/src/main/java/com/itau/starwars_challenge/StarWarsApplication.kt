package com.itau.starwars_challenge

import android.app.Application
import android.content.Context
import com.itau.starwars_challenge.di.networkModule
import com.itau.starwars_challenge.di.repositoryModule
import com.itau.starwars_challenge.di.usecaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StarWarsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupApp(baseContext)
    }

    private fun setupApp(context: Context) {
        startKoin {
            androidContext(context)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    usecaseModule

                )
            )
        }
    }
}