package com.meo.infrastructure.helpers

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build

class NetworkConnectionImpl(
    private val context: Context
) : NetworkConnection {

    override fun hasActiveInternetConnection(): Boolean {
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)
            ?.let { connectivityManager ->
                return when {
                    Build.VERSION.SDK_INT < 23 -> connectivityManager.activeNetworkInfo != null
                    Build.VERSION.SDK_INT >= 23 -> connectivityManager.activeNetwork != null
                    else -> false
                }
            }

        return false
    }
}