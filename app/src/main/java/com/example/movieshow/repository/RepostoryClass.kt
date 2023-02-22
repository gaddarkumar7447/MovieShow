package com.example.movieshow.repository

import com.example.movieshow.dao.MovieDao

class RepostoryClass(private val movieDao: MovieDao) {

    fun getMovie(){
        movieDao.getAllMovies()
    }

}