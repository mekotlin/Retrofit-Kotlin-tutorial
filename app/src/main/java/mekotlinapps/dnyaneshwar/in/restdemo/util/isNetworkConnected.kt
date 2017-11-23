package mekotlinapps.dnyaneshwar.`in`.restdemo.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by Dnyaneshwar Dalvi on 22/11/17.
 */
class NetWorkConection {

    companion object {
        @SuppressLint("MissingPermission")
        fun isNEtworkConnected(context: Context): Boolean {

            var connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectionManager.activeNetworkInfo

            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        }
    }
}
