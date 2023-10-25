package com.example.demoapp.models

data class
CheckUpdateResponse(
    val version: String?=null,
    val title: String?=null,
    val forceUpdate: Boolean?=null,
    val description: String?=null,
    val iconUrl: String?=null,
    val linkUrl: String?=null,
    val buttonTitle: String?=null
)