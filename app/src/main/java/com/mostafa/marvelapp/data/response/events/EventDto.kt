package com.mostafa.marvelapp.data.response.events


import com.mostafa.marvelapp.data.response.base.SubList
import com.mostafa.marvelapp.data.response.base.SubItem
import com.mostafa.marvelapp.data.response.base.Thumbnail
import com.mostafa.marvelapp.data.response.base.Url
import com.google.gson.annotations.SerializedName

data class EventDto(
    @SerializedName("characters")
    val characters: SubItem?,
    @SerializedName("comics")
    val comics: SubItem?,
    @SerializedName("creators")
    val creators: SubItem?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("end")
    val end: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("modified")
    val modified: String?,
    @SerializedName("next")
    val next: SubList?,
    @SerializedName("previous")
    val previous: SubList?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("series")
    val series: SubItem?,
    @SerializedName("start")
    val start: String?,
    @SerializedName("stories")
    val stories: SubItem?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("urls")
    val urls: List<Url>?
)