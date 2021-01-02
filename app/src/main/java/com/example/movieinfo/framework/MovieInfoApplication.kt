package com.example.movieinfo.framework

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Hosein on 1/2/2021.
 */
@HiltAndroidApp
class MovieInfoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}