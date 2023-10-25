package com.forceupdatekit.view.config

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

data class ForceUpdateViewConfig(
    var forceUpdateViewStyle:   ForceUpdateViewStyle = ForceUpdateViewStyle.Popover1,
    var updateImageDrawble:   Int? = null,
    var updateImageColor:   Color? = null,
    var updateImageLayoutModifier:   Modifier? = null,
    var popupViewLayoutModifier: Modifier? = null,
    var popupViewBackGroundColor: Color? = null,
    var popupViewCornerRadius: Dp? = null,
    var headerTitle: String = "It's time to update",
    var headerTitleColor: Color? = null,
    var headerTitleLayoutModifier:   Modifier? = null,
    var descriptionTitle: String = "The version you are using is old, need to update the latest version in order to experience new features.",
    var descriptionTitleColor: Color? = null,
    var descriptionTitleLayoutModifier:   Modifier? = null,
    var lineTitleColor: Color? = null,
    var lineLayoutModifier:   Modifier? = null,
    var updateButtonTitle: String? = null,
    var updateButtonTitleColor: Color? = null,
    var updateButtonColor: Color? = null,
    var updateButtonCornerRadius: Dp? = null,
    var updateButtonBorderColor: Color? = null,
    var updateButtonLayoutModifier:   Modifier? = null,
    var versionTitle: String = "Up to 12.349 version Apr 2024.",
    var versionTitleColor: Color? = null,
    var versionTitleLayoutModifier:   Modifier? = null,
    var imageView: @Composable (() -> Unit)? = null,
    var lineView: @Composable (() -> Unit)? = null,
    var headerTitleView: @Composable (() -> Unit)? = null,
    var descriptionTitleView: @Composable (() -> Unit)? = null,
    var versionTitleView: @Composable (() -> Unit)? = null,
    var buttonView: @Composable (() -> Unit)? = null,
)
