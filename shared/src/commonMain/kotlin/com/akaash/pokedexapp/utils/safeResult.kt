package com.akaash.pokedexapp.utils

suspend fun <T> safeResult(block: suspend () -> T): Resource<T> {
    return try {
        Resource.Success(data = block())
    } catch (e: Throwable) {
        Resource.Failure(throwable = e)
    }
}