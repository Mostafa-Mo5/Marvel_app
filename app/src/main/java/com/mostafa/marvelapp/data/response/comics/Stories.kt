package com.mostafa.marvelapp.data.response.comics


import com.google.gson.annotations.SerializedName

data class Stories(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("comicsItems")
    val items: List<StoriesItem>?,
    @SerializedName("returned")
    val returned: Int?
)