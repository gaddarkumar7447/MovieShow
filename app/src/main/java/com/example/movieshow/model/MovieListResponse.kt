package com.example.movieshow.model

data class MovieListResponse(
    val Search: List<Movie>,
    val totalResults: String,
    val Response: String
)
