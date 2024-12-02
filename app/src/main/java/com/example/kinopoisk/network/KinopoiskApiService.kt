package com.example.kinopoisk.network

import com.example.kinopoisk.data.ActorDetailed
import com.example.kinopoisk.data.Collection
import com.example.kinopoisk.data.Gallery
import com.example.kinopoisk.data.MovieActor
import com.example.kinopoisk.data.MovieDetailed
import com.example.kinopoisk.data.SearchByKeyword
import com.example.kinopoisk.data.Similar
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://kinopoiskapiunofficial.tech/"
private const val API_KEY = "8909a38d-6c1f-4669-916e-306963c06cb6"

interface KinopoiskApiService{

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/collections")
    suspend fun getCollection(@Query("type") type: String) : Collection

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/{id}/similars")
    suspend fun getSimilars(@Path("id") Id: Int) : Similar

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/{id}")
    suspend fun getMovie(@Path("id")  id: Int) : MovieDetailed

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v1/staff")
    suspend fun getMovieActors(@Query("id") id: Int) : MovieActor

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v1/staff/{id}")
    suspend fun getActor(@Path("id") id: Int) : ActorDetailed

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/{id}/images")
    suspend fun getGallery(@Path("id") id: Int, @Query("type") type: String) : Gallery

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.1/films/search-by-keyword")
    suspend fun getSearchByKeyword(@Query("keyword") keyword: String) : SearchByKeyword

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