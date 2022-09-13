package com.mostafa.marvelapp.data.service

import com.mostafa.marvelapp.data.response.base.BaseResponse
import com.mostafa.marvelapp.data.response.characters.CharacterDto
import com.mostafa.marvelapp.data.response.comics.ComicDto
import com.mostafa.marvelapp.data.response.creators.CreatorDto
import com.mostafa.marvelapp.data.response.events.EventDto
import com.mostafa.marvelapp.data.response.series.SeriesDto
import com.mostafa.marvelapp.data.response.stories.StoryDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("characters")
     fun getCharacter(@Query("name") name: String) : Observable<BaseResponse<CharacterDto>>

    @GET("characters")
     fun getAllCharacters() : Observable<retrofit2.Response<BaseResponse<CharacterDto>>>

    @GET("comics")
     fun getAllComics() : Observable<retrofit2.Response<BaseResponse<ComicDto>>>

    @GET("creators")
     fun getAllCreators() : Observable<retrofit2.Response<BaseResponse<CreatorDto>>>

    @GET("events")
     fun getAllEvents() : Observable<retrofit2.Response<BaseResponse<EventDto>>>

    @GET("series")
     fun getAllSeries() : Observable<retrofit2.Response<BaseResponse<SeriesDto>>>

    @GET("stories")
     fun getAllStories() : Observable<retrofit2.Response<BaseResponse<StoryDto>>>

}