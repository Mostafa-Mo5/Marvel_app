package com.mostafa.marvelapp.data.response.comics


import com.google.gson.annotations.SerializedName
import com.mostafa.marvelapp.data.response.events.CreatorsItems

data class Creators(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("comicsItems")
    val items: List<CreatorsItems>?,
    @SerializedName("returned")
    val returned: Int?
)