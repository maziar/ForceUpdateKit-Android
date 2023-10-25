package com.forceupdatekit

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.demoapp.models.CheckUpdateResponse
import com.example.testcreatelibrary.ui.view.data.ApiService
import com.example.testcreatelibrary.ui.view.data.RetrofitClientInstance
import com.forceupdatekit.config.ForceUpdateServiceConfig
import com.forceupdatekit.view.config.ForceUpdateViewStyle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ForceUpdateKit constructor(
    private var config: ForceUpdateServiceConfig = ForceUpdateServiceConfig(),
) {

    private fun checkForceUpdate(callBack: (data: CheckUpdateResponse?) -> Unit) {
        val retrofit = RetrofitClientInstance.retrofitInstance
        val apiInterface = retrofit?.create(ApiService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiInterface?.getData(
                    config.route,
                    appId = config.appId,
                    language = config.language,
                    version = config.version
                )
                if (response?.isSuccessful == true) {
                    callBack.invoke(response.body())
                }
            } catch (Ex: Exception) {
                Log.e("Error", "$Ex")
            }
        }

    }


    @Composable
    fun Configure() {
        val checkUpdateResponse: CheckUpdateResponse? = null

        var responceState by remember { mutableStateOf(checkUpdateResponse) }
        checkForceUpdate {
            if (responceState == null)
                responceState = it
        }

        if (responceState != null) {
            responceState?.let {
                ForceUpdateViewStyle.checkViewStyle(config.viewConfig.forceUpdateViewStyle)
                    .ShowView(config = config.viewConfig, it)

            }


        }


    }
}


