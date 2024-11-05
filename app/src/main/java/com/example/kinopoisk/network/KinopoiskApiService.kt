package com.example.kinopoisk.network

import com.example.kinopoisk.data.Collection
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://kinopoiskapiunofficial.tech/"
private const val API_KEY = "8909a38d-6c1f-4669-916e-306963c06cb6"

interface KinopoiskApiService{

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/collections")
    suspend fun getCollection(@Query("type") type: String) : Collection
}

object KinopoiskApi {
    val api : KinopoiskApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KinopoiskApiService::class.java)
    }
}