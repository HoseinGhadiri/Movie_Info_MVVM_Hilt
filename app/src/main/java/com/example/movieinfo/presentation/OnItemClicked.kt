package com.example.movieinfo.presentation

import com.example.core.domain.Movie

/**
 * Created by Hosein on 1/3/2021.
 */
interface OnItemClicked {
    fun onClick(movie: Movie)
}