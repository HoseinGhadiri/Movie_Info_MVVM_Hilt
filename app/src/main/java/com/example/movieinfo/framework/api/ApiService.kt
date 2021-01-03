package com.example.movieinfo.framework.api

import com.example.movieinfo.framework.network.GetDetailsResponse
import com.example.movieinfo.framework.network.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Hosein on 1/2/2021.
 */
interface ApiService {

    @GET("search/movie?")
    suspend fun search(@Query("api_key") apiKey: String,
                       @Query("language") language : String,
                       @Query("query") name : String,
                       @Query("page") page : String,
                       ): Response<SearchResponse>

    @GET("movie/{id}/keywords?")
    suspend fun details(@Path("id") movieId: Int,
                        @Query("api_key") apiKey: String): Response<GetDetailsResponse>
}