package com.example.movieinfo.framework

import android.app.Application
import com.example.core.data.MovieRepository
import com.example.movieinfo.framework.repository.MainRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * Created by Hosein on 1/2/2021.
 */
@HiltAndroidApp
class MovieInfoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
//        val apiMovieDataSource: ApiMovieDataSource()
//        val movieRepository = MovieRepository(ApiMovieDataSource)
    }
}