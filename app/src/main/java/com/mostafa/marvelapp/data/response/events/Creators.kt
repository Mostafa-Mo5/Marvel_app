package com.mostafa.marvelapp.data.response.events


import com.google.gson.annotations.SerializedName

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