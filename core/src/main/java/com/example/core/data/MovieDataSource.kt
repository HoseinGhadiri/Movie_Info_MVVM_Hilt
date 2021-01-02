package com.example.core.data

/**
 * Created by Hosein on 1/2/2021.
 */
interface MovieDataSource {
    suspend fun search(name: String)
    suspend fun getInfo(id: Int)
}