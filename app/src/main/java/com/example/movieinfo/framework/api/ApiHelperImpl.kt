package com.example.movieinfo.framework.api

import com.example.movieinfo.framework.network.GetDetailsResponse
import com.example.movieinfo.framework.network.SearchResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Hosein on 1/2/2021.
 */
class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun search(name: String): Response<SearchResponse> =
        apiService.search("25e10ff8bf8377dfb3ba9c7cb993991f",
            "en-US",
            name,
            "1",
            "false"
    )

    override suspend fun details(id: Int): Response<GetDetailsResponse> = apiService.details(id)
}