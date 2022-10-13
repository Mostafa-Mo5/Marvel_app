package com.mostafa.marvelapp.data.response.events


import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("comicsItems")
    val items: List<ComicsItems>?,
    @SerializedName("returned")
    val returned: Int?
)