package com.example.antoniolinguaglossa.mvpexample2.api

import com.google.gson.annotations.SerializedName

data class JournalerApiToken(
        @SerializedName("id_token") val token: String,
        val expires: Long
)