package com.example.movieinfo.framework.api

import com.example.movieinfo.framework.network.GetDetailsResponse
import com.example.movieinfo.framework.network.SearchResponse
import retrofit2.Response

/**
 * Created by Hosein on 1/2/2021.
 */
interface ApiHelper {

    suspend fun search(name: String): Response<SearchResponse>

    suspend fun details(id: Int): Response<GetDetailsResponse>
}