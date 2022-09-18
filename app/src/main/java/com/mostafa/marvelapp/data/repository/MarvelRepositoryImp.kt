package com.mostafa.marvelapp.data.repository

import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.data.response.character.CharacterDto
import com.mostafa.marvelapp.data.response.comics.ComicDto
import com.mostafa.marvelapp.data.response.events.EventDto
import com.mostafa.marvelapp.data.service.MarvelApiService
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class MarvelRepositoryImp(private val marvelApiService: MarvelApiService) : MarvelRepository {

    override fun getAllCharacters(): Single<State<CharacterDto>> {
        return wrapWithObservable(marvelApiService.getAllCharacters())
    }

    override fun getAllEvents(): Single<State<EventDto>> {
        return wrapWithObservable(marvelApiService.getAllEvents())
    }

    override fun getAllComics(id: Int): Single<State<ComicDto>> {
        return wrapWithObservable(marvelApiService.getAllComics(id))
    }


}


private fun <T> wrapWithObservable(response: Single<Response<T>>): Single<State<T>> {
    return response.map {
        if (it.isSuccessful) {
            State.Success(it.body())
        } else {
            State.Error(it.message())
        }
    }
}