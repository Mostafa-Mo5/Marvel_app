package com.mostafa.marvelapp.data.response.events


import com.google.gson.annotations.SerializedName

data class Stories(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<ItemXXXX>?,
    @SerializedName("returned")
    val returned: Int?
)