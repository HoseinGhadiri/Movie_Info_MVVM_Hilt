package com.example.movieinfo.framework.network

import com.example.core.domain.Movie

/**
 * Created by Hosein on 1/2/2021.
 */
data class SearchResponse (
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
    )