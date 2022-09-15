package com.mostafa.marvelapp.data.service

import com.mostafa.marvelapp.data.response.base.BaseResponse
import com.mostafa.marvelapp.data.response.characters.CharacterDto
import com.mostafa.marvelapp.data.response.comics.ComicDto
import com.mostafa.marvelapp.data.response.creators.CreatorDto
import com.mostafa.marvelapp.data.response.events.EventDto
import com.mostafa.marvelapp.data.response.series.SeriesDto
import com.mostafa.marvelapp.data.response.stories.StoryDto
import com.mostafa.marvelapp.utilies.Constants
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {


    @GET("characters")
    fun getCharacter(
        @Query("name") name: String,
        @Query("limit") limit: Int = 20,
        @Query("apikey") apiKey: String = Constants.PUBLIC_KEY,
        @Query("ts") timeStamp: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash
    ): Observable<CharacterDto>

    @GET("characters")
    fun getAllCharacters(
        @Query("limit") limit: Int = 20,
        @Query("apikey") apiKey: String = Constants.PUBLIC_KEY,
        @Query("ts") timeStamp: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash
    ): Observable<Response<CharacterDto>>

    @GET("comics")
    fun getAllComics(
        @Query("limit") limit: Int = 20,
        @Query("apikey") apiKey: String = Constants.PUBLIC_KEY,
        @Query("ts") timeStamp: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash
    ): Observable<Response<ComicDto>>

    @GET("creators")
    fun getAllCreators(
        @Query("limit") limit: Int = 20,
        @Query("apikey") apiKey: String = Constants.PUBLIC_KEY,
        @Query("ts") timeStamp: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash
    ): Observable<Response<CreatorDto>>

    @GET("events")
    fun getAllEvents(
        @Query("limit") limit: Int = 20,
        @Query("apikey") apiKey: String = Constants.PUBLIC_KEY,
        @Query("ts") timeStamp: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash
    ): Observable<Response<EventDto>>

    @GET("series")
    fun getAllSeries(): Observable<Response<SeriesDto>>

    @GET("stories")
    fun getAllStories(): Observable<Response<StoryDto>>

}