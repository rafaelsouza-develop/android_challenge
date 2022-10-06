package com.itau.starwars_challenge.data

sealed class ResultRequest<out T> {
    class Success<out T>(val data: T) : ResultRequest<T>()
    class Failure(val throwable: Throwable) : ResultRequest<Nothing>()
}