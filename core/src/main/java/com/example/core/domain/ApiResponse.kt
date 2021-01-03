package com.example.core.domain

/**
 * Created by Hosein on 1/3/2021.
 */
data class ApiResponse(
    val isSuccessful: Boolean,
    val message: String,
    val data: Any?
        )