package com.example.movieinfo.framework.utils

import android.util.Log

/**
 * Created by Hosein on 1/2/2021.
 */
object Utils {

    fun log(str: String) {
//        if (Constants.RELEASE)
//            return

        val max = 4000
        val split = str.length / max + 1
        val mod = str.length % max
        for (i in 0 until split) {
            try {
//                Timber.e(str.substring(i * max, (i + 1) * max))
                Log.w("tag", str.substring(i * max, (i + 1) * max))
            } catch (e: Exception) {
//                Timber.e(str.substring(i * max, i * max + mod))
                Log.w("tag", str.substring(i * max, i * max + mod))
            }

        }
    }
}