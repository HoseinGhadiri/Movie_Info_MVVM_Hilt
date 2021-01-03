package com.example.movieinfo.framework

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Hosein on 1/3/2021.
 */
object MovieViewModelFactory : ViewModelProvider.Factory {

    lateinit var application: Application

    lateinit var dependencies: Interactions

    fun inject(application: Application, dependencies: Interactions) {
        MovieViewModelFactory.application = application
        MovieViewModelFactory.dependencies = dependencies
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(MovieViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java, Interactions::class.java)
                .newInstance(
                    application,
                    dependencies)
        } else {
            throw IllegalStateException("ViewModel must extend MovieViewModel")
        }
    }

}