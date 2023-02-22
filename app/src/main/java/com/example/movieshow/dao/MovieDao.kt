package com.example.movieshow.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieshow.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<Movie>)

    @Query("SELECT * FROM Movie")
    fun getAllMovies(): LiveData<List<Movie>>

   /* @Query("SELECT * FROM Movie LIMIT :limit OFFSET :offset")
    fun getMovies(): LiveData<List<Movie>>*/
}