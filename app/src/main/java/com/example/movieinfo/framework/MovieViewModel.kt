package com.example.movieinfo.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * Created by Hosein on 1/3/2021.
 */
open class MovieViewModel (application: Application, protected val interactions: Interactions) :
    AndroidViewModel(application) {

    protected val application: MovieInfoApplication = getApplication()

}
