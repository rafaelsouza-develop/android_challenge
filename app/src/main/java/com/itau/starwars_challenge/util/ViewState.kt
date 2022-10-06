package com.itau.starwars_challenge.util

class ViewState<T,S>(
    val data: T? = null,
    val status: S,
    val error: Throwable? = null
)