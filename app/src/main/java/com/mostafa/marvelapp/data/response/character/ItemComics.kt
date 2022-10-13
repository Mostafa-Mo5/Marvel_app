package com.mostafa.marvelapp.data.response.character


import com.google.gson.annotations.SerializedName

data class ItemComics(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?
)