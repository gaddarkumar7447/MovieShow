package com.example.movieshow.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.movieshow.dao.MovieDatabase
import com.example.movieshow.model.Movie
import com.example.movieshow.network.MovieApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val movieDao = MovieDatabase.getDatabase(application).movieDao()

    private val movieApiService = Retrofit.Builder()
        .baseUrl("http://task.auditflo.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieApiServices::class.java)


    /*suspend fun getMovies(): LiveData<List<Movie>> {
        val moviesFromApi = movieApiService.getMovies().Search
        movieDao.insertAll(moviesFromApi)
        return movieDao.getMovies()
    }*/


    suspend fun getNewMovies(): LiveData<List<Movie>> {
        val newMoviesFromApi = movieApiService.getNewMovies().Search
        movieDao.insertAll(newMoviesFromApi)
        return movieDao.getAllMovies()
    }


}