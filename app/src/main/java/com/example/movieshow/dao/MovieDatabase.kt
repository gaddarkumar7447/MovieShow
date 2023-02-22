package com.example.movieshow.dao

import android.content.Context
import androidx.room.*
import com.example.movieshow.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context, MovieDatabase::class.java, "movie_database").build()
                }
            }
            return INSTANCE!!
        }
    }

}