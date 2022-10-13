package com.mostafa.marvelapp.data.response.events


import com.google.gson.annotations.SerializedName

data class CreatorsItems(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("role")
    val role: String?
)