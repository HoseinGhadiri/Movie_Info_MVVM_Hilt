package com.example.core.data

/**
 * Created by Hosein on 1/2/2021.
 */
class MovieRepository(private val dataSource: MovieDataSource) {

    suspend fun searchMovie(name: String) = dataSource.search(name)
    suspend fun getMovieInfo(id: Int)= dataSource.getInfo(id)
}