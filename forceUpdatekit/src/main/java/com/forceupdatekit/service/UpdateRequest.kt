package com.forceupdatekit.service

data class UpdateRequest(  var appId: String? = null,
 var version: String ,
 var route: String,
 var os: String = "Android",
 var language: String = "en")
