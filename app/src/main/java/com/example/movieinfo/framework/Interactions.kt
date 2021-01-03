package com.example.movieinfo.framework

import com.example.core.interactors.GetMovieInfo
import com.example.core.interactors.SearchMovie

/**
 * Created by Hosein on 1/2/2021.
 */
 data class Interactions (
    val getMovieInfo: GetMovieInfo,
    val searchMovie: SearchMovie
 )