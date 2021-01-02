package com.example.movieinfo.framework

import com.example.core.data.MovieDataSource

/**
 * Created by Hosein on 1/2/2021.
 */
class ApiMovieDataSource :  MovieDataSource{

    override suspend fun search(name: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getInfo(id: Int) {
        TODO("Not yet implemented")
    }
}