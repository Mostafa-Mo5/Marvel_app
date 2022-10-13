package com.mostafa.marvelapp.data.response.comics


import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("comicsItems")
    val items: List<CharactersItems?>?,
    @SerializedName("returned")
    val returned: Int?
)