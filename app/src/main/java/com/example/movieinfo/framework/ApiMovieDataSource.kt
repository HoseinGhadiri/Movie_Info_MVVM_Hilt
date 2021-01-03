package com.example.movieinfo.framework

import com.example.core.data.MovieDataSource
import com.example.core.domain.ApiResponse
import com.example.core.domain.Keyword
import com.example.movieinfo.framework.api.ApiHelper
import com.example.movieinfo.framework.network.SearchResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Hosein on 1/2/2021.
 */
class ApiMovieDataSource @Inject constructor(private val apiHelper: ApiHelper) : MovieDataSource {

    @Singleton
    val gson: Gson = GsonBuilder().serializeNulls().create()


    override suspend fun search(name: String): ApiResponse{

        return if(apiHelper.search(name).isSuccessful){
            val response : SearchResponse = gson.fromJson(apiHelper.search(name).body().toString(),
                SearchResponse::class.java)
            ApiResponse(true,"",response)
        } else{
            ApiResponse(false,apiHelper.search(name).errorBody().toString(),null)
        }
    }

    override suspend fun getInfo(id: Int): List<Keyword> {
        TODO("Not yet implemented")
    }


}