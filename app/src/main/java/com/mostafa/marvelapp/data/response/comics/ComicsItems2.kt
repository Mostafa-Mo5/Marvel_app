package com.mostafa.marvelapp.data.response.comics


import com.google.gson.annotations.SerializedName

data class ComicsItems2(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("role")
    val role: String?
)