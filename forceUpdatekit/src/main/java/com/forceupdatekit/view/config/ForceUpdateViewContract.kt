package com.forceupdatekit.view.config

import androidx.compose.runtime.Composable
import com.example.demoapp.models.CheckUpdateResponse

interface ForceUpdateViewContract {
    @Composable
    fun ShowView(config: ForceUpdateViewConfig,response: CheckUpdateResponse)
}