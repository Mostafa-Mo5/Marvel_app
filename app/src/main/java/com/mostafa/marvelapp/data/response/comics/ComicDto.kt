package com.mostafa.marvelapp.data.response.comics


import com.mostafa.marvelapp.data.response.base.SubItem
import com.mostafa.marvelapp.data.response.base.SubList
import com.mostafa.marvelapp.data.response.base.Thumbnail
import com.mostafa.marvelapp.data.response.base.Url
import com.google.gson.annotations.SerializedName

data class ComicDto(
    @SerializedName("characters")
    val characters: SubList?,
    @SerializedName("comics")
    val comics: SubList?,
    @SerializedName("creators")
    val creators: SubList?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("end")
    val end: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("next")
    val next: SubItem?,
    @SerializedName("previous")
    val previous: SubItem?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: SubList?,
    @SerializedName("start")
    val start: String?,
    @SerializedName("stories")
    val stories: SubList?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("urls")
    val urls: List<Url>?
)