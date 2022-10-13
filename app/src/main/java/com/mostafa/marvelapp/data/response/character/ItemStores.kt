package com.mostafa.marvelapp.data.response.character


import com.google.gson.annotations.SerializedName

data class ItemStores(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("type")
    val type: String?
)