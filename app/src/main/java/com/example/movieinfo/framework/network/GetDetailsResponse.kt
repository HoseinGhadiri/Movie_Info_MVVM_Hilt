package com.example.movieinfo.framework.network

/**
 * Created by Hosein on 1/2/2021.
 */

data class GetDetailsResponse(
    val id: Int,
    val keywords: List<Keyword>
)

data class Keyword(
    val id: Int,
    val name: String
)