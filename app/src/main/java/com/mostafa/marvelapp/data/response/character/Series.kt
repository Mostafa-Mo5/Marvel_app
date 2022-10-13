package com.mostafa.marvelapp.data.response.character


import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("comicsItems")
    val comicsItems: List<ItemComics>?,
    @SerializedName("returned")
    val returned: Int?
)