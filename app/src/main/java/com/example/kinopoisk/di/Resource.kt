package com.example.kinopoisk.di

sealed class Resource<out Data> {
    data object Initial: Resource<Nothing>()
    data object Loading: Resource<Nothing>()
    data object Empty: Resource<Nothing>()
    data class Error(val exception: Throwable): Resource<Nothing>()
    data class Success<out Data>(val data: Data): Resource<Data>()
}