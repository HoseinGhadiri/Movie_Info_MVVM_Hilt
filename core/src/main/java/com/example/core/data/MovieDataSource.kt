package com.example.core.data

import com.example.core.domain.ApiResponse
import com.example.core.domain.Keyword


/**
 * Created by Hosein on 1/2/2021.
 */
interface MovieDataSource {
    suspend fun search(name: String): ApiResponse
    suspend fun getInfo(id: Int) : List<Keyword>
}