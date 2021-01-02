package com.example.core.interactors

import com.example.core.data.MovieRepository

/**
 * Created by Hosein on 1/2/2021.
 */
class SearchMovie(private val movieRepository: MovieRepository ) {
    suspend operator fun invoke(name: String)= movieRepository.searchMovie(name)
}