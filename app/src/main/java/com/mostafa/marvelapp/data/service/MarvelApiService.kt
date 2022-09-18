package com.mostafa.marvelapp.data.service

import com.mostafa.marvelapp.data.response.character.CharacterDto
import com.mostafa.marvelapp.data.response.comics.ComicDto
import com.mostafa.marvelapp.data.response.events.EventDto
import com.mostafa.marvelapp.utilies.Constants
import com.mostafa.marvelapp.utilies.Constants.PUBLIC_KEY
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {

    @GET("/v1/public/characters")
    fun getAllCharacters(
        @Query("limit") limit: Int = 100,
        @Query("orderBy") orderBy: String = "-modified",
        @Query("apikey") apiKey: String = PUBLIC_KEY,
        @Query("ts") timeStamp: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash
    ): Single<Response<CharacterDto>>

    @GET("/v1/public/characters/{characterId}/comics")
    fun getAllComics(
        @Path("characterId") characterId: Int?,
        @Query("limit") limit: Int = 100,
        @Query("noVariants") noVariants: Boolean = false,
        @Query("apikey") apiKey: String = PUBLIC_KEY,
        @Query("ts") timeStamp: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash
    ): Single<Response<ComicDto>>

    @GET("/v1/public/events")
    fun getAllEvents(
        @Query("orderBy") orderBy: String = "modified",
        @Query("limit") limit: Int = 100,
        @Query("apikey") apiKey: String = PUBLIC_KEY,
        @Query("ts") timeStamp: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash
    ): Single<Response<EventDto>>

}