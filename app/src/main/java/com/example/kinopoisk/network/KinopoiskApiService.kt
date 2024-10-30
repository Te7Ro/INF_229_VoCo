package com.example.kinopoisk.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://kinopoiskapiunofficial.tech/documentation/api/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface KinopoiskApiService{
    @GET("shtoto")
    suspend fun getShtoto() : String
}

object KinopoiskApi {
    val retrofitService : KinopoiskApiService by lazy {
        retrofit.create(KinopoiskApiService::class.java)
    }
}