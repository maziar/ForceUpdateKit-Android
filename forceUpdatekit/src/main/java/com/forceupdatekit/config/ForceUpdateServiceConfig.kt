package com.forceupdatekit.config

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.forceupdatekit.view.config.ForceUpdateViewConfig

data class ForceUpdateServiceConfig(
    var viewConfig: ForceUpdateViewConfig = ForceUpdateViewConfig(),
    var route: String = "https://my.api.mockaroo.com/forceupdate.json?key=2202ab40",
    var packageName: String? = null,
    var version: String = "0.0.0",
    var appId: String = "Android",
    var language: String? = "en",

    )