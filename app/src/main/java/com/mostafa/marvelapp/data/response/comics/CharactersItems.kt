package com.mostafa.marvelapp.data.response.comics


import com.google.gson.annotations.SerializedName

data class CharactersItems(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?
)