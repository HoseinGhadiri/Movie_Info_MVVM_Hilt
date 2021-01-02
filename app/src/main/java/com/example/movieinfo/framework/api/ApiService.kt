package com.example.movieinfo.framework.api

import com.example.movieinfo.framework.network.GetDetailsResponse
import com.example.movieinfo.framework.network.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Hosein on 1/2/2021.
 */
interface ApiService {

    @GET("api/{name}")
    suspend fun search(@Path("name") movieName: String): Response<SearchResponse>

    @GET("api/{id}")
    suspend fun details(@Path("id") movieId: Int): Response<GetDetailsResponse>
}