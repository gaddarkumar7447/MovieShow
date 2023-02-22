package com.example.movieshow.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_database")
data class Movie(
    @PrimaryKey val IMDBID: String,
    val Title: String,
    val Year: String,
    val Runtime: String,
    val Director: String,
    val Poster : String,
    val Cast : String
)
