package com.example.movieinfo.framework.api

import com.example.movieinfo.framework.network.GetDetailsResponse
import com.example.movieinfo.framework.network.SearchResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Hosein on 1/2/2021.
 */
class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun search(name: String): Response<SearchResponse> =  apiService.search(name)

    override suspend fun details(id: Int): Response<GetDetailsResponse> = apiService.details(id)
}