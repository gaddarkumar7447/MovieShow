package com.example.movieshow.network

import com.example.movieshow.model.MovieListResponse
import retrofit2.http.GET

interface MovieApiServices {
    @GET("1.json")
    suspend fun getMovies(): MovieListResponse

    @GET("2.json")
    suspend fun getNewMovies(): MovieListResponse
}