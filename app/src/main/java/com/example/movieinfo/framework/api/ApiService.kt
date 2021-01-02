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

//    @GET("api/{name}")
//    @GET("search/movie?api_key=25e10ff8bf8377dfb3ba9c7cb993991f&language=en-US&query={name}&page=1&include_adult=false")
    @GET("search/movie?")
    suspend fun search(@Query("api_key") apiKey: String,
                       @Query("language") language : String,
                       @Query("query") name : String,
                       @Query("page") page : String,
                       @Query("include_adult") include_adult : String,
                       ): Response<SearchResponse>
//    suspend fun search(@Query("name") movieName: String): Response<SearchResponse>

    @GET("api/{id}")
    suspend fun details(@Path("id") movieId: Int): Response<GetDetailsResponse>
}