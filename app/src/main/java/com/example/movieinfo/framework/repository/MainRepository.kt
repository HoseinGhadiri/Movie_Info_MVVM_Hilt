package com.example.movieinfo.framework.repository

import com.example.movieinfo.framework.api.ApiHelper
import javax.inject.Inject

/**
 * Created by Hosein on 1/2/2021.
 */
class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun search(name: String) = apiHelper.search(name)
    suspend fun details(id: Int) = apiHelper.details(id)
}