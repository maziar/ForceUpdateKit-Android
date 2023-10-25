package com.forceupdatekit.view.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.demoapp.models.CheckUpdateResponse
import com.forceupdatekit.R
import com.forceupdatekit.theme.Black100
import com.forceupdatekit.theme.Orange80
import com.forceupdatekit.theme.Typography
import com.forceupdatekit.view.config.ForceUpdateViewConfig
import com.forceupdatekit.view.config.ForceUpdateViewContract

class ForceUpdateViewPopover2 : ForceUpdateViewContract {

    @Composable
    override fun ShowView(config: ForceUpdateViewConfig, response: CheckUpdateResponse) {

        Dialog(onDismissRequest = { }) {
            Surface(
                modifier = config.popupViewLayoutModifier ?: Modifier
                    .fillMaxHeight(0.7f)
                    .fillMaxWidth(8f),
                shape = RoundedCornerShape(config.popupViewCornerRadius ?: 15.dp),
                color = config.popupViewBackGroundColor ?: Black100
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageView(config)
                    HeaderTitle(config, response)
                    DescriptionTitle(config, response)
                    ButtonUpdate(config, response)
                    VersionTitle(config, response)
                }
            }

        }

    }


    @Composable
    private fun ImageView(config: ForceUpdateViewConfig) {
        Surface(
            modifier = config.updateImageLayoutModifier ?: Modifier
                .padding(top = 60.dp)
                .wrapContentSize(),
            color = Color.Transparent,

            ) {
            if (config.imageView != null) config.imageView?.let { it() } else Icon(
                painter = painterResource(id = config.updateImageDrawble ?: R.drawable.seting),
                contentDescription = null,
                tint = config.updateImageColor ?: Orange80
            )
        }

    }

    @Composable
    private fun HeaderTitle(
        config: ForceUpdateViewConfig,
        response: CheckUpdateResponse
    ) {
        Surface(
            modifier = config.headerTitleLayoutModifier ?: Modifier
                .padding(top = 30.dp, end = 15.dp, start = 15.dp)
                .wrapContentSize(),
            color = Color.Transparent,

            ) {
            config.headerTitleView ?: Text(
                text = response.title ?: config.headerTitle,
                style = Typography.titleMedium,
                color = config.headerTitleColor ?: Typography.titleMedium.color

            )
        }

    }

    @Composable
    private fun DescriptionTitle(
        config: ForceUpdateViewConfig,
        response: CheckUpdateResponse
    ) {
        Surface(
            modifier =config.descriptionTitleLayoutModifier ?: Modifier
                .padding(top = 20.dp, end = 15.dp, start = 15.dp)
                .wrapContentSize(),
            color = Color.Transparent,

            ) {
            config.descriptionTitleView ?: Text(
                text = response.description
                    ?: config.descriptionTitle,
                style = Typography.titleSmall,
                color = config.descriptionTitleColor ?: Typography.titleSmall.color

            )
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ButtonUpdate(
        config: ForceUpdateViewConfig,
        response: CheckUpdateResponse
    ) {
        val uriHandler = LocalUriHandler.current

        Surface(modifier =config.updateButtonLayoutModifier ?: Modifier
            .padding(top = 40.dp)
            .wrapContentSize(),
            color = Color.Transparent,
            onClick = {
                response.linkUrl?.let { openLink(it, uriHandler) }
            }

        ) {

            if (config.buttonView != null) config.buttonView?.let { it() } else ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                shape = RoundedCornerShape(config.updateButtonCornerRadius ?: 18.dp),

                colors = CardDefaults.cardColors(
                    containerColor = config.updateButtonColor ?: Orange80,

                    ),
                modifier = Modifier
                    .size(height = 48.dp, width = 182.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = config.updateButtonTitle ?: ("Update New Version"),
                        style = Typography.titleMedium
                    )
                }
            }
        }

    }

    @Composable
    private fun VersionTitle(
        config: ForceUpdateViewConfig,
        response: CheckUpdateResponse

    ) {
        Surface(
            modifier = config.versionTitleLayoutModifier ?: Modifier
                .padding(
                    top = LocalConfiguration.current.screenHeightDp.dp * 0.02f,
                    end = 15.dp,
                    start = 15.dp
                )
                .wrapContentSize(),
            color = Color.Transparent,

            ) {
            config.versionTitleView ?: Text(
                text = response.version
                    ?: config.versionTitle,
                style = Typography.titleSmall,
                color = config.versionTitleColor ?: Orange80

            )
        }

    }

    private fun openLink(url: String, uriHandler: UriHandler) {
        uriHandler.openUri(url)
    }

}