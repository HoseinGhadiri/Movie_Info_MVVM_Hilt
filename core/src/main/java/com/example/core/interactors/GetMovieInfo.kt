package com.example.core.interactors

import com.example.core.data.MovieRepository

/**
 * Created by Hosein on 1/2/2021.
 */
class GetMovieInfo(private val movieRepository: MovieRepository) {
    suspend operator fun invoke(id: Int) = movieRepository.getMovieInfo(id)
}