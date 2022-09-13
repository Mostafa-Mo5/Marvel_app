package com.mostafa.marvelapp.data.response.characters


import com.mostafa.marvelapp.data.response.base.SubList
import com.mostafa.marvelapp.data.response.base.Thumbnail
import com.google.gson.annotations.SerializedName
import com.mostafa.marvelapp.data.response.base.BaseResponse

data class CharacterDto(
    @SerializedName("comics")
    val comics: SubList?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("events")
    val events: SubList?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: SubList?,
    @SerializedName("stories")
    val stories: SubList?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("urls")
    val urls: List<SubList>?
)